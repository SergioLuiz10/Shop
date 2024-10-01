package model.Execução;

import db.DB;
import db.DbException;
import model.dao.departamentoDao;
import model.entities.departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class departamentoDaoBanco implements departamentoDao {
    private Connection conn;

    public departamentoDaoBanco(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserindo(departamento dp) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, dp.getName());

            int linhasMudadas = st.executeUpdate();

            if (linhasMudadas > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int novoIDD = rs.getInt(1);
                    dp.setId(novoIDD);
                }
            } else {
                throw new DbException("Error! Nenhuma linha foi mudada.");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void mudança(departamento dp) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
            st.setString(1, dp.getName());
            st.setInt(2, dp.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    // Novo método para deletar registros relacionados (como seller)
    public void deleteSellersByDepartmentId(Integer departmentId) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM seller WHERE DepartmentId = ?");
            st.setInt(1, departmentId);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletePeloId(Integer id) {
        PreparedStatement st = null;

        try {

            deleteSellersByDepartmentId(id);

            // Agora pode deletar o departamento
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new DbException("Departamento com id " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                throw new DbException("Não é possível excluir o departamento pois ele está sendo referenciado por outro registro.");
            } else {
                throw new DbException(e.getMessage());
            }
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public departamento achandoPeloId(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                departamento dp = new departamento();
                dp.setId(rs.getInt("Id"));
                dp.setName(rs.getString("Name"));
                return dp;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<departamento> achandoTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<departamento> list = new ArrayList<>();

        try {
            st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
            rs = st.executeQuery();

            while (rs.next()) {
                departamento dp = new departamento();
                dp.setId(rs.getInt("Id"));
                dp.setName(rs.getString("Name"));
                list.add(dp);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}

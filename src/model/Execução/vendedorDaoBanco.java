package model.Execução;

import db.DB;
import db.DbException;
import model.dao.vendedorDao;
import model.entities.departamento;
import model.entities.vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class vendedorDaoBanco implements vendedorDao {


    private Connection con;


    public vendedorDaoBanco(Connection con){
        this.con=con;
    }

    @Override
    public void inserindo(vendedor vd) {


    }

    @Override
    public void mudando(vendedor vd) {


    }

    @Override
    public void deletandoPeloId(Integer id) {


    }

    @Override
    public vendedor achandoPeloId(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("SELECT seller.*, department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                departamento dp = new departamento();
                dp.setId(rs.getInt("DepartmentId"));
                dp.setName(rs.getString("DepName")); 

                vendedor vd = new vendedor();
                vd.setId(rs.getInt("Id"));
                vd.setName(rs.getString("Name"));
                vd.setEmail(rs.getString("Email"));
                vd.setSalario(rs.getDouble("BaseSalary"));
                vd.setNascimento(rs.getDate("BirthDate"));
                vd.setDep(dp);

                return vd;
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
    public List<vendedor> achandoTodos() {


        return List.of();
    }
}

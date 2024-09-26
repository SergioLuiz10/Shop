package model.Execução;

import db.DB;
import db.DbException;
import model.dao.vendedorDao;
import model.entities.departamento;
import model.entities.vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                departamento dp = estanciandoDepartamento(rs);

                vendedor vd = estanciandoVendedor(rs ,dp);
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
   private departamento estanciandoDepartamento(ResultSet rs) throws SQLException{
      departamento dp =new departamento();
       dp.setId(rs.getInt("DepartmentId"));
       dp.setName(rs.getString("DepName"));

       return dp;
   }
   private vendedor estanciandoVendedor(ResultSet rs , departamento dp) throws SQLException{
       vendedor vd = new vendedor();
       vd.setId(rs.getInt("Id"));
       vd.setName(rs.getString("Name"));
       vd.setEmail(rs.getString("Email"));
       vd.setSalario(rs.getDouble("BaseSalary"));
       vd.setNascimento(rs.getDate("BirthDate"));
       vd.setDep(dp);

       return vd;
   }

    @Override
    public List<vendedor> achandoTodos() {


        return List.of();
    }

    @Override
    public List<vendedor> achandoPeloDepartamento(departamento dp)  {
      PreparedStatement st = null;
      ResultSet rs = null;
      try {
          st = con.prepareStatement("SELECT seller.*, department.Name as DepName "
                  + "FROM seller INNER JOIN department "
                  + "ON seller.DepartmentId = department.Id "
                  + "WHERE DepartmentId = ? "
                  + "ORDER BY seller.Name");

      st.setInt(1,dp.getId());
      rs = st.executeQuery();

      List<vendedor> list = new ArrayList<>();
      Map<Integer ,departamento> map= new HashMap<>();
      while (rs.next()){

           dp =  map.get(rs.getInt("DepartmentId"));

          if(dp == null){
              dp = estanciandoDepartamento(rs);
              map.put(rs.getInt("DepartmentId"),dp);
          }
          vendedor vd = estanciandoVendedor(rs ,dp);
          list.add(vd);
      }
       return list;
      }catch (SQLException e){
          throw new DbException(e.getMessage());
      }finally {
          DB.closeStatement(st);
          DB.closeResultSet(rs);
      }
    }
}

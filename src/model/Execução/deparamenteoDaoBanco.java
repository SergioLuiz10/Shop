package model.Execução;

import model.dao.departamentoDao;
import model.entities.departamento;

import java.sql.Connection;
import java.util.List;

public class deparamenteoDaoBanco implements departamentoDao {


   private Connection con ;

   public deparamenteoDaoBanco (Connection con){
       this.con=con;
   }
    @Override
    public void inserindo(departamento dp) {

    }

    @Override
    public void mudança(departamento dp) {

    }

    @Override
    public void deletePeloId(Integer id) {

    }

    @Override
    public departamento achandoPeloId(Integer id) {

        return null;
    }

    @Override
    public List<departamento> achandoTodos() {

        return List.of();
    }
}

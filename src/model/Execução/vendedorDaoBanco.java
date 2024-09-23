package model.Execução;

import model.dao.vendedorDao;
import model.entities.vendedor;

import java.util.List;

public class vendedorDaoBanco implements vendedorDao {

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


        return null;
    }

    @Override
    public List<vendedor> achandoTodos() {


        return List.of();
    }
}

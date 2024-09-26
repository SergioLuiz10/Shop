package model.dao;

import model.entities.departamento;
import model.entities.vendedor;

import java.util.List;

public interface vendedorDao {

    void inserindo(vendedor vd);
    void mudando(vendedor vd);
    void deletandoPeloId(Integer id);
    vendedor achandoPeloId(Integer id);
    List<vendedor> achandoTodos();
    List<vendedor> achandoPeloDepartamento(departamento dp);

}

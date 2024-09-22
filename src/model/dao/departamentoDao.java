package model.dao;

import model.entities.departamento;

import java.util.List;

public interface departamentoDao {

    void inserindo(departamento dp);
    void mudança(departamento dp);
    void deletePeloId(Integer id);
    departamento achandoPeloId(Integer id);
    List<departamento> achandoTodos();
}

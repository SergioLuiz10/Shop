package model.dao;

import db.DB;
import model.Execução.departamentoDaoBanco;

public class localDao {

    public static departamentoDao criarDepartamento(){
        return new departamentoDaoBanco(DB.getConnection());
    }
}

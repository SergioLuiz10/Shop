package model.dao;

import db.DB;
import model.Execução.vendedorDaoBanco;

public class fabricaDao {

    public static vendedorDao criarVendedorDao(){
        return new vendedorDaoBanco(DB.getConnection());
    }
}

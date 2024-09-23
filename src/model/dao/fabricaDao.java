package model.dao;

import model.Execução.vendedorDaoBanco;

public class fabricaDao {

    public static vendedorDao criarVendedorDao(){
        return new vendedorDaoBanco();
    }
}

package application;

import model.dao.fabricaDao;
import model.dao.vendedorDao;
import model.entities.vendedor;



public class programa {
    public static void main(String[] args) {


        vendedorDao vendedordao = fabricaDao.criarVendedorDao();
        vendedor vd = vendedordao.achandoPeloId(3);
        System.out.println(vd);
    }
}

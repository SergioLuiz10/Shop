package application;

import model.dao.fabricaDao;
import model.dao.vendedorDao;
import model.entities.vendedor;



public class programa {
    public static void main(String[] args) {

        vendedorDao vendedordao = fabricaDao.criarVendedorDao();
        System.out.println("=== Testando : vendedor achando pelo id");
        vendedor vd = vendedordao.achandoPeloId(3);
        System.out.println(vd);
    }
}

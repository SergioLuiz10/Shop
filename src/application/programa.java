package application;

import model.dao.fabricaDao;
import model.dao.vendedorDao;
import model.entities.departamento;
import model.entities.vendedor;

import java.util.Date;

public class programa {
    public static void main(String[] args) {
        departamento dp = new departamento(1,"Bolacha");
        System.out.println(dp);

        vendedorDao vendedordao = fabricaDao.criarVendedorDao();
        vendedor vd = new vendedor(10,"lucas","kkk@gaml.com",new Date(),3000.00,dp);
        System.out.println(vd);
    }
}

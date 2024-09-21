package application;

import model.entities.departamento;
import model.entities.seller;

import java.util.Date;

public class programa {
    public static void main(String[] args) {
        departamento dp = new departamento(1,"Bolacha");
        System.out.println(dp);


        seller sl = new seller(10,"lucas","kkk@gaml.com",new Date(),3000.00,dp);
        System.out.println(sl);
    }
}

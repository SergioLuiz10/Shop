package application;

import model.dao.departamentoDao;
import model.dao.localDao;
import model.entities.departamento;
import java.util.List;

public class programaDepartamento {
    public static void main(String[] args) {

        departamentoDao departamentoDao = localDao.criarDepartamento();
        System.out.println("=== Testando : departamento achando pelo id");
        departamento dp = departamentoDao.achandoPeloId(2);
        System.out.println(dp);
        System.out.println("Testando: departamento achartodos ");
        List<departamento> list = departamentoDao.achandoTodos();
        for (departamento departamentoDiferente : list){
            System.out.println(departamentoDiferente);
        }
        departamento novoDP = new departamento(1,"MacBook");
        departamentoDao.inserindo(novoDP);
        System.out.println("novo departamento="+ novoDP.getId());


        System.out.println("Testando : departamento mudando ");
        departamento alterado = new departamento(5,"Playstation five");
        departamento alterado2 = new departamento(6,"Tv");
        departamento alterado3 = new departamento(8,"Minoxidil");
        departamento alterado4 = new departamento(9,"Mouse");
        departamentoDao.mudança(alterado);
        departamentoDao.mudança(alterado2);
        departamentoDao.mudança(alterado3);
        departamentoDao.mudança(alterado4);

        System.out.println("Alterado :"+alterado);
        System.out.println("Alterado :"+alterado2);
        System.out.println("Alterado :"+alterado3);
        System.out.println("Alterado :"+alterado4);


        System.out.println("Testado : deletar do departamento:");
        departamentoDao.deletePeloId(13);

    }
}

package biblioteca;

import Basicas.Autor;
import Basicas.Cliente;
import Basicas.Endereco;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Biblioteca {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_biblioteca");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Cliente cli1 = new Cliente();
        cli1.setNome("Alexandre");
        cli1.setCpf("112.897.623-11");
        cli1.setEmail("Alexandre@gmail.com");
        Calendar dataCli1 = Calendar.getInstance();
        dataCli1.set(1964, 25, 4);
        cli1.setDataNasc(dataCli1);

        Endereco end = new Endereco();
        end.setLogradouro("Rua da Concórdia");
        end.setBairro("Caseb");
        end.setCidade("Feira de Santana");
        end.setEstado("Bahia");
        end.setPessoa(cli1);

//        Autor aut = new Autor();
//        aut.setNome("Jorge Leal de Faria");
//        aut.setCpf("433.435.645-65");
//        aut.setEmail("Jorgão.amadinho@gmail.com");
//        Calendar dataAutor = Calendar.getInstance();
//        dataAutor.set(1912, 3, 5);
//        aut.setDataNasc(dataAutor);
//        aut.setNomeDeAutor("Jorge Amado");
//
//        em.persist(aut);
        em.persist(end);
        em.persist(cli1);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}

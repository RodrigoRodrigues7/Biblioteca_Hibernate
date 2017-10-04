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
        cli1.setMatricula(1);
        cli1.setNome("Alexandre");
        cli1.setCpf("112.897.623-11");
        cli1.setEmail("Alexandre@gmail.com");
        Calendar dataCli1 = Calendar.getInstance();
        dataCli1.set(1964, 25, 4);
        cli1.setDataNasc(dataCli1);

        Endereco end1 = new Endereco();
        end1.setLogradouro("Rua da Concórdia");
        end1.setBairro("Caseb");
        end1.setCidade("Feira de Santana");
        end1.setEstado("Bahia");
        cli1.setEndereco(end1);
        
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
//
        em.persist(cli1);
        em.persist(end1);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}

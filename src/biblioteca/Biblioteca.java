package biblioteca;

//import Basicas.Autor;
//import Basicas.Cliente;
import Basicas.Endereco;
//import java.util.Calendar;
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

//        Cliente cli = new Cliente();
//        cli.setNome("Alexandre Conselheiro");
//        cli.setCpf("112.897.623-11");
//        cli.setEmail("Aledipop.xande@gmail.com");
//        Calendar dataCliente = Calendar.getInstance();
//        dataCliente.set(1964, 25, 4);
//        cli.setDataNasc(dataCliente);
//        cli.setMatricula(1);
//        Autor aut = new Autor();
//        aut.setNome("Jorge Leal de Faria");
//        aut.setCpf("433.435.645-65");
//        aut.setEmail("Jorgão.amadinho@gmail.com");
//        Calendar dataAutor = Calendar.getInstance();
//        dataAutor.set(1912, 3, 5);
//        aut.setDataNasc(dataAutor);
//        aut.setNomeDeAutor("Jorge Amado");

        

        Endereco end = new Endereco();
        end.setLogradouro("Rua da Concórdia");
        end.setBairro("Caseb");
        end.setCidade("Feira de Santana");
        end.setEstado("Bahia");
//        end.setPessoa(aut);

        em.persist(end);
//        em.persist(aut);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
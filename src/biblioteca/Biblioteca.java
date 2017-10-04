package biblioteca;

import Basicas.Autor;
import Basicas.Cliente;
import Basicas.Editora;
import Basicas.Endereco;
import Basicas.Livro;
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
//
        Endereco end1 = new Endereco();
        end1.setLogradouro("Rua da Concórdia");
        end1.setBairro("Caseb");
        end1.setCidade("Feira de Santana");
        end1.setEstado("Bahia");
        cli1.setEndereco(end1);
//
//=========================================================
//
        Autor aut1 = new Autor();
        aut1.setNome("Jorge Armando");
        aut1.setCpf("433.435.645-65");
        aut1.setEmail("Jorge@gmail.com");
        Calendar dataAutor1 = Calendar.getInstance();
        dataAutor1.set(1912, 3, 5);
        aut1.setDataNasc(dataAutor1);
        aut1.setNomeDeAutor("Jorge Amado");
//
        Endereco end2 = new Endereco();
        end2.setLogradouro("Rua Tijucas");
        end2.setBairro("Cordeiro");
        end2.setCidade("Recife");
        end2.setEstado("Pernambuco");
        aut1.setEndereco(end2);
//
        Autor aut2 = new Autor();
        aut2.setNome("José Peraira");
        aut2.setCpf("111.242.54-23");
        aut2.setEmail("Jose@gmail.com");
        Calendar dataAutor2 = Calendar.getInstance();
        dataAutor2.set(1934, 2, 23);
        aut2.setDataNasc(dataAutor2);
        aut2.setNomeDeAutor("Pereira Souza");
//        
        Endereco end3 = new Endereco();
        end3.setLogradouro("Rua Nobre");
        end3.setBairro("Graças");
        end3.setCidade("Recife");
        end3.setEstado("Pernambuco");
        aut2.setEndereco(end3);
//        
        Autor aut3 = new Autor();
        aut3.setNome("Liro Silva");
        aut3.setCpf("555.444.618-87");
        aut3.setEmail("Liro@gmail.com");
        Calendar dataAutor3 = Calendar.getInstance();
        dataAutor3.set(1912, 3, 5);
        aut3.setDataNasc(dataAutor3);
        aut3.setNomeDeAutor("Lira");
//        
        Endereco end4 = new Endereco();
        end4.setLogradouro("Rua Beato");
        end4.setBairro("Casa Forte");
        end4.setCidade("João Pessoa");
        end4.setEstado("Paraíba");
        aut3.setEndereco(end4);
//
//=========================================================
//
        Editora edi1 = new Editora();
        edi1.setNome("MARINHO");
        edi1.setCidade("São Paulo");
//
        Editora edi2 = new Editora();
        edi2.setNome("SANTA PAULA");
        edi2.setCidade("Paraná");
//        
//=========================================================
//
        Livro liv1 = new Livro();
        liv1.setTitulo("AAAAAA");
        liv1.setEditora(edi1);
        Calendar anoLiv1 = Calendar.getInstance();
        anoLiv1.set(1934, 2, 22);
        liv1.setAnoDePublicacao(anoLiv1);
        liv1.getAutores().add(aut1);
//        
        Livro liv2 = new Livro();
        liv2.setTitulo("BBBBBB");
        liv2.setEditora(edi2);
        Calendar anoLiv2 = Calendar.getInstance();
        anoLiv2.set(1998, 11, 30);
        liv2.setAnoDePublicacao(anoLiv2);  
        liv2.getAutores().add(aut1);
        liv2.getAutores().add(aut2);
        liv2.getAutores().add(aut3);
//
        Livro liv3 = new Livro();
        liv3.setTitulo("CCCCCC");
        liv3.setEditora(edi1);
        Calendar anoLiv3 = Calendar.getInstance();
        anoLiv3.set(2002, 4, 7);
        liv3.setAnoDePublicacao(anoLiv3);
        liv3.getAutores().add(aut3);  

        edi1.getLivrosEditora().add(liv1);
        edi2.getLivrosEditora().add(liv2);
        edi1.getLivrosEditora().add(liv3);
//
//=========================================================
//
        em.persist(cli1);
        em.persist(aut1);
        em.persist(aut2);
        em.persist(aut3);
//        
        em.persist(liv1);
        em.persist(liv2);
        em.persist(liv3);
//        
        em.persist(edi1);
        em.persist(edi2);
//
        em.persist(end1);
        em.persist(end2);
        em.persist(end3);
        em.persist(end4);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}

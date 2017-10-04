    package Basicas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cidade;
    
    @OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Livro> livrosEditora = new ArrayList<Livro>();
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public List<Livro> getLivrosEditora() {
        return livrosEditora;
    }
    
    public void setLivrosEditora(ArrayList<Livro> livrosEditora) {
        this.livrosEditora = livrosEditora;
    }

}

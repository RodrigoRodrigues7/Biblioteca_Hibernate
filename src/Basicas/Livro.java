package Basicas;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Livro {

    @Id
    private int id;
    private String titulo;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Autor_Livros",
            joinColumns = @JoinColumn(name = "ID_Livro"),
            inverseJoinColumns = @JoinColumn(name = "ID_Autor"))
    private List<Autor> autores;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_Editora",
            insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Editora editora;
    
    private Calendar anoDePublicacao;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public List<Autor> getAutores() {
        return autores;
    }
    
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    public Editora getEditora() {
        return editora;
    }
    
    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    public Calendar getAnoDePublicacao() {
        return anoDePublicacao;
    }
    
    public void setAnoDePublicacao(Calendar anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.titulo);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

}

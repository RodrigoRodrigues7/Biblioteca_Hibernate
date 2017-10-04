package Basicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Autor extends Pessoa {

    private String nomeDeAutor;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Autor_Livros",
            joinColumns = @JoinColumn(name = "ID_Autor"),
            inverseJoinColumns = @JoinColumn(name = "ID_Livro"))
    private List<Livro> LivrosAutor = new ArrayList<Livro>();

    public String getNomeDeAutor() {
        return nomeDeAutor;
    }

    public void setNomeDeAutor(String nmAutor) {
        this.nomeDeAutor = nmAutor;
    }

    public List<Livro> getLivrosAutor() {
        return LivrosAutor;
    }

    public void setLivrosAutor(ArrayList<Livro> Livros) {
        this.LivrosAutor = Livros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nomeDeAutor);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nomeDeAutor, other.nomeDeAutor)) {
            return false;
        }
        return true;
    }

}

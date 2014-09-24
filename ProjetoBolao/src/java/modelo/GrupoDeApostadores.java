package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "GrupoDeApostadores")
public class GrupoDeApostadores {

    @Id
    @GeneratedValue
    @Column(name = "cod_grupo_de_apostadores")
    int cod_grupo_de_apostadores;

    @Column(name = "nome", length = 50)
    private String nome;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_apostador")
    @Fetch(FetchMode.JOIN)
    private List<Apostador> apostadores = new ArrayList<Apostador>();

    public int getCod_grupo_de_apostadores() {
        return cod_grupo_de_apostadores;
    }

    public void setCod_grupo_de_apostadores(int cod_grupo_de_apostadores) {
        this.cod_grupo_de_apostadores = cod_grupo_de_apostadores;
    }

    public List<Apostador> getApostadores() {
        return apostadores;
    }

    public void setApostadores(List<Apostador> apostadores) {
        this.apostadores = apostadores;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

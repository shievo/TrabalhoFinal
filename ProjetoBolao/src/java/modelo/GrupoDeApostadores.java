package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GrupoDeApostadores")
public class GrupoDeApostadores {

    @Id
    @GeneratedValue
    @Column(name = "codigo")
    int codigo;

    @Column(name = "nome", length = 50)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

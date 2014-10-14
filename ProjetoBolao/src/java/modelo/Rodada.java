package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.envers.Audited;

/**
 *
 * @author Renan
 */
@Entity
@Audited
@Table(name = "Rodada")
public class Rodada implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_rodada")
    private Integer cod_rodada;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(name = "data_final_apostas", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_final_apostas;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cod_competicao")
    @Fetch(FetchMode.JOIN)
    private Competicao competicao;
/*
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cod_jogo")
    @Fetch(FetchMode.JOIN)
    private List<Jogo> jogos = new ArrayList<Jogo>();
*/
    public Integer getCod_rodada() {
        return cod_rodada;
    }

    public void setCod_rodada(Integer cod_rodada) {
        this.cod_rodada = cod_rodada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_final_apostas() {
        return data_final_apostas;
    }

    public void setData_final_apostas(Date data_final_apostas) {
        this.data_final_apostas = data_final_apostas;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

/**
 *
 * @author Kelvin
 */
@Entity
@Audited
@Table(name = "Competicao")
public class Competicao implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_competicao")
    private int cod_competicao;
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_competicao")
    @Fetch(FetchMode.JOIN)
    private List<AssociarTimeCompeticao> associar_time_competicao = new ArrayList<AssociarTimeCompeticao>();
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_rodada")
    @Fetch(FetchMode.JOIN)
    private List<Rodada> rodadas = new ArrayList<Rodada>();

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inicio;
    
    @Column(name = "data_fim", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim;

    public int getCod_competicao() {
        return cod_competicao;
    }

    public void setCod_competicao(int cod_competicao) {
        this.cod_competicao = cod_competicao;
    }

    public List<AssociarTimeCompeticao> getAssociar_time_competicao() {
        return associar_time_competicao;
    }

    public void setAssociar_time_competicao(List<AssociarTimeCompeticao> associar_time_competicao) {
        this.associar_time_competicao = associar_time_competicao;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<Rodada> rodadas) {
        this.rodadas = rodadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

}

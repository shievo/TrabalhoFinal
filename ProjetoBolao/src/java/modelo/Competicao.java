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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Kelvin
 */
@Entity
@Table(name = "competicao")
public class Competicao implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_competicao")
    private Integer cod_competicao;
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_categoria")
    @Fetch(FetchMode.JOIN)
    private List<AssociarTimeCompeticao> associar_time_competicao = new ArrayList<AssociarTimeCompeticao>();

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "data_inicio", nullable = true)
    private Date data_inicio;
    @Column(name = "data_fim", nullable = true)
    private Date data_fim;

    public List<AssociarTimeCompeticao> getAssociar_time_competicao() {
        return associar_time_competicao;
    }

    public void setAssociar_time_competicao(List<AssociarTimeCompeticao> associar_time_competicao) {
        this.associar_time_competicao = associar_time_competicao;
    }
    
    public Integer getCod_competicao() {
        return cod_competicao;
    }

    public void setCod_competicao(Integer cod_competicao) {
        this.cod_competicao = cod_competicao;
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

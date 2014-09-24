/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Kelvin
 */
@Entity
@Table(name = "competicao")
public class AssociarTimeCompeticao implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_associar_time_competicao")
    private Integer cod_associar_time_competicao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo")
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo")
    private Competicao competicao;

    public Integer getCod_associar_time_competicao() {
        return cod_associar_time_competicao;
    }

    public void setCod_associar_time_competicao(Integer cod_associar_time_competicao) {
        this.cod_associar_time_competicao = cod_associar_time_competicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}

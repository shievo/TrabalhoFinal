/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    @Column(name = "codigo")
    private Integer codigo;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "time", cascade = CascadeType.ALL)
    private Time time;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "competicao", cascade = CascadeType.ALL)
    private Competicao competicao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

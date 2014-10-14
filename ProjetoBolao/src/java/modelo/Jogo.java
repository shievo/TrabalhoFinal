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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

/**
 *
 * @author Renan
 */

@Entity
@Audited
@Table(name = "Jogo")
public class Jogo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_jogo")
    private Integer cod_jogo;

    @Column(name = "time1", nullable = true)
    private Time time1;
    
    @Column(name = "placar_time1")
    private int placar_time1;
    
    @Column(name = "time2", nullable = true)
    private Time time2;
    
    @Column(name = "placar_time2")
    private int placar_time2;
    
    @Column(name = "data_jogo", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_jogo;
    
    @Column(name = "vencedor", nullable = true)
    private Time vencedor;
/*
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cod_aposta")
    @Fetch(FetchMode.JOIN)
    private List<Aposta> apostas = new ArrayList<Aposta>();
*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_rodada")
    private Rodada rodada;

    public Integer getCod_jogo() {
        return cod_jogo;
    }

    public void setCod_jogo(Integer cod_jogo) {
        this.cod_jogo = cod_jogo;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public int getPlacar_time1() {
        return placar_time1;
    }

    public void setPlacar_time1(int placar_time1) {
        this.placar_time1 = placar_time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public int getPlacar_time2() {
        return placar_time2;
    }

    public void setPlacar_time2(int placar_time2) {
        this.placar_time2 = placar_time2;
    }

    public Date getData_jogo() {
        return data_jogo;
    }

    public void setData_jogo(Date data_jogo) {
        this.data_jogo = data_jogo;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public void setVencedor(Time vencedor) {
        this.vencedor = vencedor;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

}

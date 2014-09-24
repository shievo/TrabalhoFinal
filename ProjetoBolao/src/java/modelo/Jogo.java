/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Renan
 */

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_jogo")
    private Integer cod_jogo;

    @Column(name = "time1", length = 150, nullable = true)
    private String time1;
    
    @Column(name = "palcar_time1")
    private int palcar_time1;
    
    @Column(name = "time2", length = 150, nullable = true)
    private String time2;
    
    @Column(name = "palcar_time2")
    private int palcar_time2;
    
    @Column(name = "data_jogo", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_jogo;
    
    @Column(name = "vencedor", nullable = true)
    private Time vencedor;

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public void setPalcar_time1(int palcar_time1) {
        this.palcar_time1 = palcar_time1;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public void setPalcar_time2(int palcar_time2) {
        this.palcar_time2 = palcar_time2;
    }

    public void setData_jogo(Date dat_jogo) {
        this.data_jogo = dat_jogo;
    }

    public String getTime1() {
        return time1;
    }

    public int getPalcar_time1() {
        return palcar_time1;
    }

    public String getTime2() {
        return time2;
    }

    public int getPalcar_time2() {
        return palcar_time2;
    }

    public Date getData_jogo() {
        return data_jogo;
    }

    public Integer getCod_jogo() {
        return cod_jogo;
    }

    public void setCod_jogo(Integer cod_jogo) {
        this.cod_jogo = cod_jogo;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public void setVencedor(Time vencedor) {
        this.vencedor = vencedor;
    }
}

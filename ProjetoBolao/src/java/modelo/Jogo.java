/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Date;

/**
 *
 * @author Renan
 */
public class Jogo {
    
    private String time1;
    private int palcar_time1;
    private String time2;
    private int palcar_time2;
    private Date dat_jogo;
    private String vencedor;

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

    public void setDat_jogo(Date dat_jogo) {
        this.dat_jogo = dat_jogo;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
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

    public Date getDat_jogo() {
        return dat_jogo;
    }

    public String getVencedor() {
        return vencedor;
    }
     
}

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Aposta")
public class Aposta implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_aposta")
    private int cod_aposta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_apostador")
    private Apostador apostador;

    @Column(name = "data_aposta", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_aposta;

    @Column(name = "jogo")
    private Jogo jogo;

    @Column(name = "placar_time1")
    private int placar_time1;

    @Column(name = "placar_time2")
    private int placar_time2;

    @Column(name = "vencedor")
    private Time vencedor;

    public int getCod_aposta() {
        return cod_aposta;
    }

    public void setCod_aposta(int cod_aposta) {
        this.cod_aposta = cod_aposta;
    }

    public Apostador getApostador() {
        return apostador;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public Date getData_aposta() {
        return data_aposta;
    }

    public void setData_aposta(Date data_aposta) {
        this.data_aposta = data_aposta;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getPlacar_time1() {
        return placar_time1;
    }

    public void setPlacar_time1(int placar_time1) {
        this.placar_time1 = placar_time1;
    }

    public int getPlacar_time2() {
        return placar_time2;
    }

    public void setPlacar_time2(int placar_time2) {
        this.placar_time2 = placar_time2;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public void setVencedor(Time vencedor) {
        this.vencedor = vencedor;
    }
}

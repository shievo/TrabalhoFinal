
package modelo;

import java.io.Serializable;
import java.sql.Date;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "rodada")
public class Rodada implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "cod_rodada")
     private Integer cod_rodada;
        
    @Column(name = "nome", length = 150, nullable = true)
    private String nome;
    
    @Column(name = "data_final_apostas", length = 150, nullable = true)
    private Date data_final_apostas;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_competicao")
    @Fetch(FetchMode.JOIN)
    private List<Competicao> competicao = new ArrayList<Competicao>();
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_jogo")
    @Fetch(FetchMode.JOIN)
    private List<Jogo> jogos = new ArrayList<Jogo>();

    public void setCodigo(Integer codigo) {
        this.cod_rodada = codigo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_final_apostas(Date data_final_apostas) {
        this.data_final_apostas = data_final_apostas;
    }

    public Integer getCodigo() {
        return cod_rodada;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_final_apostas() {
        return data_final_apostas;
    }
}

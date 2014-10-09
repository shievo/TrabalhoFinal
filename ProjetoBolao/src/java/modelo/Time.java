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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "time")
public class Time implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cod_time")
    private int cod_time;
    
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="cod_time")
    @Fetch(FetchMode.JOIN)
    private List<AssociarTimeCompeticao> associar_time_competicao = new ArrayList<AssociarTimeCompeticao>();

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cidade", nullable = true)
    private String cidade;
    
    @Column(name = "site", nullable = true)
    private String site;
    
    @Column(name = "email", nullable = true)
    private String email;
    
    @Column(name = "historico", length = 100, nullable = true)
    private String historico;
    
    @Column(name = "fone", nullable = true)
    private String fone;
    
    @Column(name = "endereco", nullable = true)
    private String endereco;
    
    @Column(name = "data_fundacao", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fundacao;
    
    @Column(name = "data_cadastro", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_cadastro;

    public int getCod_time() {
        return cod_time;
    }

    public void setCod_time(int cod_time) {
        this.cod_time = cod_time;
    }

    public List<AssociarTimeCompeticao> getAssociar_time_competicao() {
        return associar_time_competicao;
    }

    public void setAssociar_time_competicao(List<AssociarTimeCompeticao> associar_time_competicao) {
        this.associar_time_competicao = associar_time_competicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(Date data_fundacao) {
        this.data_fundacao = data_fundacao;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

}

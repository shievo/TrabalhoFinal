package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "time")
public class Time implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "codigo")
    private Integer codigo;
    

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AssociarTimeCompeticao associar_time_competicao;

    @Column(name = "nome", length = 50)
    private String nome;
    
    @Column(name = "cidade", length = 50, nullable = true)
    private String cidade;
    
    @Column(name = "site", length = 50, nullable = true)
    private String site;
    
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    
    @Column(name = "historico", length = 100, nullable = true)
    private String historico;
    
    @Column(name = "fone", length = 50, nullable = true)
    private String fone;
    
    @Column(name = "endereco", length = 50, nullable = true)
    private String endereco;
    
    @Column(name = "data_fundacao", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fundacao;
    
    @Column(name = "data_cadastro", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_cadastro;

    public Time(int codigo, String nome, String cidade, String site, String email, String historico, String fone, String endereco, Date data_fundacao, Date data_cadastro) {
        this.nome = nome;
        this.cidade = cidade;
        this.site = site;
        this.email = email;
        this.historico = historico;
        this.fone = fone;
        this.endereco = endereco;
        this.data_fundacao = data_fundacao;
        this.data_cadastro = data_cadastro;
    }

    public Time() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public AssociarTimeCompeticao getAssociar_time_competicao() {
        return associar_time_competicao;
    }

    public void setAssociar_time_competicao(AssociarTimeCompeticao associar_time_competicao) {
        this.associar_time_competicao = associar_time_competicao;
    }
}

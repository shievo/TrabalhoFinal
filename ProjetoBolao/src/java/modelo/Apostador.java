package modelo;

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
@Table(name = "Apostador")
public class Apostador {

    @Id
    @GeneratedValue
    @Column(name = "cod_apostador")
    private Integer cod_apostador;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_nascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "time_preferido")
    private Time time_preferido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_grupo_de_apostadores")
    private GrupoDeApostadores grupo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Time getTime_preferido() {
        return time_preferido;
    }

    public void setTime_preferido(Time time_preferido) {
        this.time_preferido = time_preferido;
    }

    public GrupoDeApostadores getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDeApostadores grupo) {
        this.grupo = grupo;
    }

}

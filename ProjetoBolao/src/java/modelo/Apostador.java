package modelo;

import java.util.Date;

public class Apostador {

    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String email;
    private String apelido;
    private Time time_preferido;
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

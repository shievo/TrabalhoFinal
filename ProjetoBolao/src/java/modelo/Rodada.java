
package modelo;

import java.sql.Date;

/**
 *
 * @author Renan
 */
public class Rodada {
    
    private String nome;
    private Date data_final_apostas;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_final_apostas(Date data_final_apostas) {
        this.data_final_apostas = data_final_apostas;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_final_apostas() {
        return data_final_apostas;
    }
}

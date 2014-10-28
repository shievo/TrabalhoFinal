/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Shievo
 */
public class Conexao {

    private String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private String BD = "sample";
    private String URL = "jdbc:derby://localhost:1527/" + BD;
    private String USERNAME = "app";
    private String PASSWORD = "app";
    private Connection conexao;
    private Statement stm;
    private String msg;
    private PreparedStatement PrepStmt;

    public void iniciaConexao() {
        try {
            Class.forName(this.DRIVER);
            this.conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // Definimos o objeto responsÃ¡vel por executar os comandos
            this.stm = this.getConexao().createStatement();
             
        } catch (ClassNotFoundException e) {
            this.conexao = null;
        } catch (SQLException e) {
            this.conexao = null;
        }
    }
    
    
    public void fechaConexao() {
        try {
            if (this.conexao != null) {
                this.conexao.close();
                this.conexao = null;
            }
            if (this.stm != null) {
                this.stm = null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao encerrar conexão.");
        }
    }
    
    public Statement getStm(){
        return stm;
    }
    
    public PreparedStatement getPrepStmt(){
        return PrepStmt;
    }
    
    public Connection getConexao(){
        return conexao;
    }
}

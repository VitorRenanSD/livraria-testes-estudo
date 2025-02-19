package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private final String ip;
    private final String porta;
    private final String banco;
    private final String usuario;
    private final String senha;

    public Conexao(String ip, String porta, String banco, String usuario, String senha) {
        this.ip = ip;
        this.porta = porta;
        this.banco = banco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void conectaBanco() throws SQLException {
        Connection conexao = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://" + this.ip + ":" + this.porta + "/" + this.banco, this.usuario, this.senha);
            System.out.println("Banco conectado com sucesso!");

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados nao encontrado");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}

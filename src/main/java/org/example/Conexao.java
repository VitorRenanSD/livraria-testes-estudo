package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) throws SQLException {
        Connection conexao = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/livraria_teste", "postgres", "@skydiver2442!");
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM cliente");

            while (rsCliente.next()) {
                System.out.println("Nome: " + rsCliente.getString("nome"));
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados nao encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro ao acessar o banco: " + ex.getMessage());;
        } finally {
            if (conexao != null) {
                conexao.close();
            }

        }
    }
}

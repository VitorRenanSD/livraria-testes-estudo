package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Conexao banco1 = new Conexao("localhost", "5432", "livraria_teste", "postgres", "@skydiver2442!");

        banco1.conectaBanco();
    }
}

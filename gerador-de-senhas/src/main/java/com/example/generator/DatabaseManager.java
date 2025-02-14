package com.example.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/gerador_senhas";
    private static final String USER = "root";
    private static final String PASSWORD = "SUA_SENHA_DO_MYSQL";

    private static DatabaseManager instance;
    private Connection connection;

    private DatabaseManager() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    public void salvarUsuario(String usuario, String senhaHash, String algoritmo) {
        String sql = "INSERT INTO usuarios (usuario, senha_hash, algoritmo) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senhaHash);
            stmt.setString(3, algoritmo);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuário salvo no banco de dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário no banco de dados: " + e.getMessage());
        }
    }

    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão com o banco: " + e.getMessage());
            }
        }
    }
}
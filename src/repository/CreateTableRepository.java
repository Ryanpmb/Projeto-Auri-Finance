package repository;

import contracts.repository.ICreateTable;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTableRepository implements ICreateTable {

    private final Connection connection;

    public CreateTableRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void CreateUserTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100) NOT NULL,
                date_of_birth DATE,
                phone_number VARCHAR(20),
                email VARCHAR(100) UNIQUE NOT NULL,
                password VARCHAR(255) NOT NULL,
                role_id INT,
                cpf VARCHAR(14) UNIQUE,
                address TEXT,
                created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                FOREIGN KEY (role_id) REFERENCES roles(id)
            );
        """;
        execute(sql);
    }

    @Override
    public void CreateUserBankAccounteTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS user_bank_accounts (
                id INT PRIMARY KEY AUTO_INCREMENT,
                banking_institution_name VARCHAR(100),
                banking_institution_type VARCHAR(50),
                bank_agency INT,
                account_number INT,
                created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            );
        """;
        execute(sql);
    }

    @Override
    public void CreateRoleTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS roles (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(50) UNIQUE NOT NULL,
                created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            );
        """;
        execute(sql);
    }

    @Override
    public void CreatePermissionTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS permissions (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(50) UNIQUE NOT NULL,
                created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            );
        """;
        execute(sql);
    }

    @Override
    public void CreatePermissionRoleTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS permission_role (
                role_id INT NOT NULL,
                permission_id INT NOT NULL,
                PRIMARY KEY (role_id, permission_id),
                FOREIGN KEY (role_id) REFERENCES roles(id),
                FOREIGN KEY (permission_id) REFERENCES permissions(id)
            );
        """;
        execute(sql);
    }

    private void execute(String sql) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}

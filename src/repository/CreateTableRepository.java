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
        String sql = ""
            + "CREATE TABLE IF NOT EXISTS users (\n"
            + "    id SERIAL PRIMARY KEY,\n"
            + "    name VARCHAR(100) NOT NULL,\n"
            + "    date_of_birth DATE,\n"
            + "    phone_number VARCHAR(20),\n"
            + "    email VARCHAR(100) UNIQUE NOT NULL,\n"
            + "    password VARCHAR(255) NOT NULL,\n"
            + "    role_id INT,\n"
            + "    cpf VARCHAR(14) UNIQUE,\n"
            + "    address TEXT,\n"
            + "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n"
            + "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n"
            + "    FOREIGN KEY (role_id) REFERENCES roles(id)\n"
            + ");";
        execute(sql);
    }

    @Override
    public void CreateUserBankAccounteTable() {
        String sql = ""
            + "CREATE TABLE IF NOT EXISTS user_bank_accounts (\n"
            + "    id SERIAL PRIMARY KEY,\n"
            + "    banking_institution_name VARCHAR(100),\n"
            + "    banking_institution_type VARCHAR(50),\n"
            + "    bank_agency INT,\n"
            + "    account_number INT,\n"
            + "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n"
            + "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n"
            + ");";
        execute(sql);
    }

    @Override
    public void CreateRoleTable() {
        String sql = ""
            + "CREATE TABLE IF NOT EXISTS roles (\n"
            + "    id SERIAL PRIMARY KEY,\n"
            + "    name VARCHAR(50) UNIQUE NOT NULL,\n"
            + "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n"
            + "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n"
            + ");";
        execute(sql);
    }

    @Override
    public void CreatePermissionTable() {
        String sql = ""
            + "CREATE TABLE IF NOT EXISTS permissions (\n"
            + "    id SERIAL PRIMARY KEY,\n"
            + "    name VARCHAR(50) UNIQUE NOT NULL,\n"
            + "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n"
            + "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n"
            + ");";
        execute(sql);
    }

    @Override
    public void CreatePermissionRoleTable() {
        String sql = ""
            + "CREATE TABLE IF NOT EXISTS permission_role (\n"
            + "    role_id INT NOT NULL,\n"
            + "    permission_id INT NOT NULL,\n"
            + "    PRIMARY KEY (role_id, permission_id),\n"
            + "    FOREIGN KEY (role_id) REFERENCES roles(id),\n"
            + "    FOREIGN KEY (permission_id) REFERENCES permissions(id)\n"
            + ");";
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

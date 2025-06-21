package seeders;

import java.sql.Connection;

import contracts.seeders.IRoleSeeders;

public class RoleSeeders implements IRoleSeeders {
    private Connection connection;

    public RoleSeeders(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        String sql = "INSERT INTO roles (name) VALUES (?)";

        try (var pstmt = connection.prepareStatement(sql)) {
            System.out.println("Preparando inserção...");
            pstmt.setString(1, "Admin");
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + rowsAffected);
            System.out.println("Role 'Admin' criada com sucesso");
        } catch (Exception e) {
            System.err.println("Erro completo:");
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar Role: " + e.getMessage(), e);
        }
    }
}

package repository;

import contracts.repository.IUserRepository;
import database.ConnectionFactory;

import java.sql.Connection;
import java.util.List;
import model.User;

public class UserRepository implements IUserRepository{
    private final Connection connection;
    public UserRepository(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public User create(User attributes) {
        String sql = "INSERT INTO users (name, date_of_birth, phone_number, email, password, role_id, cpf, address) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";

        try (var pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, attributes.getName());
            pstmt.setDate(2, java.sql.Date.valueOf(attributes.getDate_of_birth())); // yyyy-MM-dd
            pstmt.setString(3, attributes.getPhone_number());
            pstmt.setString(4, attributes.getEmail());
            pstmt.setString(5, attributes.getPassword());
            pstmt.setInt(6, attributes.getRoleId());
            pstmt.setString(7, attributes.getCpf());
            pstmt.setString(8, attributes.getAddress());

            pstmt.executeUpdate();
            return attributes;
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir usuário: " + e.getMessage(), e);
        }
    }


    @Override
    public User findById(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findMany() {
        // TODO Auto-generated method stub
        return null;
    }

    
}

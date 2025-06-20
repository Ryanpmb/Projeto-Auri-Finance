package repository;

import contracts.repository.IUserRepository;
import database.ConnectionFactory;

import java.sql.Connection;
import java.util.List;
import model.User;

public class UserRepository implements IUserRepository{
    private final Connection connection;
    public UserRepository()
    {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public User create(User attributes) {
        
        return null;
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

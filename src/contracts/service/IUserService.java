package contracts.service;

import java.util.List;

import model.User;

public interface IUserService {
    public User create(User attributes);
    public User findById(int userId);
    public List<User> findMany();
}

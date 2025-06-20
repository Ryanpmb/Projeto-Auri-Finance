package contracts.repository;

import java.util.List;
import model.User;

public interface IUserRepository {
    public User create(User attributes);
    public User findById(int userId);
    public List<User> findMany();
}

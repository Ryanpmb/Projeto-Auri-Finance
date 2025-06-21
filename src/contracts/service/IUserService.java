package contracts.service;

import java.util.List;
import java.util.Scanner;

import model.User;

public interface IUserService {
    public User create(Scanner scanner, User user);
    public List<User> listUsers();
}

package service;

import models.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getAllUsers();
    void createNewUser(User user);
    void deleteUser(int id);
}

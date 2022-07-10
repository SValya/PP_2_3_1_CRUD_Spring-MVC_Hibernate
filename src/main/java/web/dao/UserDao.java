package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void add(User user);

    void remove(Long id);

    void edit(User user);

    User getById(Long id);

}

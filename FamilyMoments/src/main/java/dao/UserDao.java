package dao;

import domain.User;

public interface UserDao extends BaseDao<User> {
    public User findByName(String name);
}

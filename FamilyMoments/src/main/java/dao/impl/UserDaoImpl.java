package dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Override
    public User findByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List result = session.createQuery("select u from User u where u.name='" + name + "'").list();
        if (!result.isEmpty() && result.get(0) instanceof User)
            return (User)result.get(0);
        return null;
    }
}

package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}

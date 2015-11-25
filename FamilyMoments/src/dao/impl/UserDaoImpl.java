package dao.impl;

import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}

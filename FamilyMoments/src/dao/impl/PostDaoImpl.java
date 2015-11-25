package dao.impl;

import org.springframework.transaction.annotation.Transactional;

import dao.PostDao;
import domain.Post;
@Transactional
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{

}

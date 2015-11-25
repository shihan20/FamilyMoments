package dao.impl;

import org.springframework.transaction.annotation.Transactional;

import dao.CommentDao;
import domain.Comment;
@Transactional
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{

}

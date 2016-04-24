package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CommentDao;
import domain.Comment;

@Repository
@Transactional
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{

}

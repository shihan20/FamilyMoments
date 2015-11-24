package service.impl;

import java.util.Date;

import dao.*;
import service.PostsService;
import domain.*;

public class PostsServiceImpl implements PostsService{
	private CommentDao commentDao;
	private ContentDao contentDao;
	private ImgContentDao imgContentDao;
	private PostDao postDao;
	private UserDao userDao;
	private VideoContentDao videoContentDao;
	
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}
	public void setImgContentDao(ImgContentDao imgContentDao) {
		this.imgContentDao = imgContentDao;
	}
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setVideoContentDao(VideoContentDao videoContentDao) {
		this.videoContentDao = videoContentDao;
	}
	
	public void updateTextPost(String text, int userid){
		Post post = new Post();
		Date date = new Date();
		post.setDate(date);
		Content content = new Content();
		content.setText(text);
		post.setContent(content);
		User user = userDao.get(User.class, userid);
		post.setPublisher(user);
		postDao.save(post);
	}
}

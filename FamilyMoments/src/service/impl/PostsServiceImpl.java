package service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import dao.*;
import dao.impl.UserDaoImpl;
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
	
	public List<Post> getTimeline(int userid, int firstResult, int maxResults) {
		//System.out.println(userDao.get(User.class, 1).getName());
		Set<User> set = userDao.get(User.class, userid).getFriends();
		set.add(userDao.get(User.class, userid));
		return postDao.getUsersPosts(set, firstResult, maxResults);
	}
	
	public void updateTextPost(String text, int userid) {
		Post post = new Post();
		Date date = new Date();
		post.setDate(date);
		Content content = new Content();
		content.setText(text);
		try {
		contentDao.save(content);
		post.setContent(content);
		User user = userDao.get(User.class, userid);
		post.setPublisher(user);
		postDao.save(post);
		}
		catch (HibernateException e) {
			System.out.println("there is a hibernate exception");
			System.out.println(e);
		}
	}
}

package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.SimpleDateFormat;
import dao.*;
import dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.PostsService;
import domain.*;

@Service
@Transactional
public class PostsServiceImpl implements PostsService{
	private CommentDao commentDao;
	private ContentDao contentDao;
	private ImgContentDao imgContentDao;
	private PostDao postDao;
	private UserDao userDao;
	private VideoContentDao videoContentDao;

	@Autowired
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	@Autowired
	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}
	@Autowired
	public void setImgContentDao(ImgContentDao imgContentDao) {
		this.imgContentDao = imgContentDao;
	}
	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Autowired
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

	public void updateImgPost(String text, String savePath, int userid) {
		Post post = new Post();
		Date date = new Date();
		post.setDate(date);
		User user = userDao.get(User.class, userid);
		post.setPublisher(user);

		//ArrayList is designed to store a number of images' URLs. ONLY support one single img for now.
		ImgContent content = new ImgContent();
		content.setText(text);
		ArrayList<String> a = new ArrayList<String>();
		a.add(savePath);
		content.setImgUrls(a);
		contentDao.save(content);
		post.setContent(content);

		postDao.save(post);
	}

	public void likePost(int userid, int postid) {
		User user = userDao.get(User.class, userid);
		Post post = postDao.get(Post.class, postid);
		post.getLikes().add(user);
		postDao.update(post);
	}

	public void cancelLikePost(int userid, int postid) {
		User user = userDao.get(User.class, userid);
		Post post = postDao.get(Post.class, postid);

		List<User> likes = post.getLikes();
		for (int i=0; i<likes.size(); i++) {
			if (likes.get(i).getId() == userid)
				likes.remove(i);
		}
		System.out.println(post.getLikes());
		postDao.update(post);
	}

	public List<User> getLikes(int postid) {
		Post post = postDao.get(Post.class, postid);
		return post.getLikes();
	}
}

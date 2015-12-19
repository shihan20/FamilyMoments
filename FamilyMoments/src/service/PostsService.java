package service;

import java.util.List;
import java.util.Set;

import domain.Post;
import domain.User;

public interface PostsService {
	List<Post> getTimeline(int userid, int firstResult, int maxResults);
	void updateTextPost(String context, int userid) throws Exception;
	void likePost(int userid, int postid);
	void cancelLikePost(int userid, int postid);
	List<User> getLikes(int postid);
}

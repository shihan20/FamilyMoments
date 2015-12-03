package service;

import java.util.List;

import domain.Post;

public interface PostsService {
	List<Post> getTimeline(int userid, int firstResult, int maxResults);
	void updateTextPost(String context, int userid) throws Exception;
}

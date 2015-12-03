package dao;

import java.util.List;
import java.util.Set;

import domain.Post;
import domain.User;

public interface PostDao extends BaseDao<Post> {
	public List<Post> getUsersPosts(Set<User> users, int firstResult, int maxResults);
}

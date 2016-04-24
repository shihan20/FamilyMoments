package dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dao.PostDao;
import domain.*;

@Repository
@Transactional
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{
	public List<Post> getUsersPosts(Set<User> users, int firstResult, int maxResults) {
		Session sess = getSessionFactory().getCurrentSession();
		Transaction tx = sess.beginTransaction();
		String hql = "select p "
				+ "from Post p "
				+ "where p.publisher in :users "
				+ "order by p.id desc";
		Query query = sess.createQuery(hql);
		query.setParameterList("users", users);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		List<Post> list = query.list();
		tx.commit();
		return list;
	}
}

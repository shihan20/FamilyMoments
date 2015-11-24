package domain;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(targetEntity=Post.class, mappedBy="publisher")
	private Set<Post> posts;
	@OneToMany(targetEntity=Comment.class, mappedBy="at")
	private Set<Comment> ateds;
	private String name;
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Comment> getAteds() {
		return ateds;
	}

	public void setAteds(Set<Comment> ateds) {
		this.ateds = ateds;
	}
}

package domain;
import java.util.HashSet;
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
	private String profile_picture;
	@ManyToMany(targetEntity=User.class)
	@JoinTable(name="user_friends",
			joinColumns=@JoinColumn(name="user_id", referencedColumnName="user_id"),
			inverseJoinColumns=@JoinColumn(name="friends_id", referencedColumnName="user_id"))
	private Set<User> friends = new HashSet<>();
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

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public User() {
		profile_picture = "img/profile_picture_" + id + ".jpg";
	}
}

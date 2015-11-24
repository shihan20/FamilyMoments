package domain;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Post {
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	@OneToOne(targetEntity=Content.class)
	@JoinColumn(name="content_id", referencedColumnName="content_id")
	private Content content;
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="publisher_user_id", referencedColumnName="user_id", nullable=false)
	private User publisher;
	@ManyToMany(targetEntity=User.class)
	@JoinTable(name="post_like_user",
			joinColumns=@JoinColumn(name="post_id", referencedColumnName="post_id"),
			inverseJoinColumns=@JoinColumn(name="like_user_id", referencedColumnName="user_id"))
	private Set<User> likes;
	@OneToMany(targetEntity=Comment.class, mappedBy="post")
	private Set<Comment> comments;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	public Set<User> getLikes() {
		return likes;
	}
	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
}

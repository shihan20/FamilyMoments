package domain;
import java.util.Date;
import javax.persistence.*;
@Entity
public class Comment {
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String text;
	private Date date;
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="at_user_id", referencedColumnName="user_id")
	private User at;
	@ManyToOne(targetEntity=Post.class)
	@JoinColumn(name="post_id", referencedColumnName="post_id")
	private Post post;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getAt() {
		return at;
	}
	public void setAt(User at) {
		this.at = at;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}

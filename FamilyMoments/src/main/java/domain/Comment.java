package domain;
import java.util.Date;
import javax.persistence.*;

public class Comment {
	private Integer id;
	private String text;
	private Date date;
	private User at;
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

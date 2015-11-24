package domain;
import javax.persistence.*;

@Entity
@DiscriminatorColumn
@DiscriminatorValue("text_content")
public class Content {
	@Id
	@Column(name="content_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String text;
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
}
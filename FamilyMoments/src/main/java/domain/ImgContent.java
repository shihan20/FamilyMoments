package domain;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@DiscriminatorValue("image_content")
public class ImgContent extends Content {
	private ArrayList<String> imgUrls;

	public ArrayList<String> getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(ArrayList<String> imgUrls) {
		this.imgUrls = imgUrls;
	}
}

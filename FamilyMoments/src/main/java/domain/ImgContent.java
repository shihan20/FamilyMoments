package domain;
import java.util.ArrayList;
import javax.persistence.*;

public class ImgContent extends Content {
	private String imgUrls;

	public String getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}
}

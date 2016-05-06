package domain;
import javax.persistence.*;

@Entity
@DiscriminatorValue("video_content")
public class VideoContent extends Content {
	private String videoUrl;

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}

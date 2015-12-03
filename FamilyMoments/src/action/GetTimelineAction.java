package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import domain.Post;
import service.PostsService;
import org.json.*;

import com.opensymphony.xwork2.Action;

public class GetTimelineAction implements Action{
	private PostsService postsService;
	private String result;

	public void setPostsService(PostsService postsService) {
		this.postsService = postsService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute() throws Exception {
		List<Post> posts = postsService.getTimeline(1, 0, 10);
		JSONArray jsonArray = new JSONArray();
		for (Post post : posts) {
			Map map = new HashMap();
			map.put("publisher", post.getPublisher().getName());
			map.put("date", post.getDate().getTime());
			map.put("text", post.getContent().getText());
			jsonArray.put(map);
		}
		result = jsonArray.toString();
		return SUCCESS;
	}
}

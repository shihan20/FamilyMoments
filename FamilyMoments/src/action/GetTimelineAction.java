package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Post;
import service.PostsService;

import org.apache.struts2.ServletActionContext;
import org.json.*;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

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
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
                .get(ServletActionContext.HTTP_REQUEST);
		String page = request.getParameter("page");
		int currPage = Integer.parseInt(page);
		List<Post> posts = postsService.getTimeline(1, 10*currPage, 10);
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

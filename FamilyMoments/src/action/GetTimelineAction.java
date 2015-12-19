package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Post;
import domain.User;
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
		int currPage = Integer.parseInt(request.getParameter("page"));
		List<Post> posts = postsService.getTimeline(1, 10*currPage, 10);
		JSONArray jsonArray = new JSONArray();
		for (Post post : posts) {
			Map map = new HashMap();
			map.put("id", post.getId());
			map.put("publisher_name", post.getPublisher().getName());
			map.put("publisher_profile_picture", post.getPublisher().getProfile_picture());
			map.put("date", post.getDate().getTime());
			map.put("text", post.getContent().getText());
			List<User> likes = post.getLikes();
			JSONArray jsonArray1 = new JSONArray();
			for (User like_user : likes) {
				Map map1 = new HashMap<>();
				map1.put("username", like_user.getName());
				jsonArray1.put(map1);
			}
			map.put("likes", jsonArray1.toString());
			jsonArray.put(map);
		}
		result = jsonArray.toString();

		//System.out.println("test vcs");

		return SUCCESS;
	}
}

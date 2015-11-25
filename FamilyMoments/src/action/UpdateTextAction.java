package action;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;
import service.*;

public class UpdateTextAction implements Action{
	private String text;
	private PostsService postsService;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PostsService getPostsService() {
		return postsService;
	}

	public void setPostsService(PostsService postsService) {
		this.postsService = postsService;
	}

	public String execute() throws Exception{

		System.out.println(text);
		postsService.updateTextPost(text, 1);
		return SUCCESS;
	}
}

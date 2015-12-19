package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import domain.User;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import service.PostsService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shihan on 12/19/15.
 */
public class LikeAction implements Action{
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

    public String execute() throws Exception{
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context
                .get(ServletActionContext.HTTP_REQUEST);
        int userid = Integer.parseInt(request.getParameter("userid"));
        int postid = Integer.parseInt(request.getParameter("postid"));
        if (Integer.parseInt(request.getParameter("cancel")) == 0)
            postsService.likePost(userid, postid);
        else
            postsService.cancelLikePost(userid, postid);
        List<User> likes = postsService.getLikes(postid);
        JSONArray jsonArray = new JSONArray();
        for (User like_user : likes) {
            Map map = new HashMap<>();
            map.put("username", like_user.getName());
            jsonArray.put(map);
        }
        result = jsonArray.toString();
        return SUCCESS;
    }
}

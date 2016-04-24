package controller;

import domain.ImgContent;
import domain.Post;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.PostsService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by shihan on 16/4/12.
 */

@Controller
public class IndexController {
    private PostsService postsService;

    @Autowired
    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/updateText", method = RequestMethod.POST)
    public String updateText(@RequestParam String text) throws Exception{
        System.out.println(text);
        if (text != "")
            postsService.updateTextPost(text, 1);
        return "redirect:/index";
    }

    @RequestMapping(value = "/updateImg", method = RequestMethod.POST)
    public String updateImg(@RequestParam(defaultValue = "") String text, @RequestPart MultipartFile uploadPic, HttpServletRequest request){
        //get current date and make new directory such as "/savePath/YEAR/MONTH/DATE"
        Calendar c = Calendar.getInstance();
        //generate unique filename to save file
        StringBuffer fileNameBuffer = new StringBuffer(uploadPic.getOriginalFilename());
        fileNameBuffer.replace(0, fileNameBuffer.lastIndexOf("."), java.util.UUID.randomUUID().toString());
        String fileName = fileNameBuffer.toString();
        String relativeDirPath = new StringBuffer("uploadFiles/").append(c.get(Calendar.YEAR)).append("/").append(c.get(Calendar.MONTH)).append("/").append(c.get(Calendar.DATE)).toString();
        String absoluteDirPath = new StringBuffer(request.getSession().getServletContext().getRealPath("/")).append(relativeDirPath).toString();
        String relativeFilePath = new StringBuffer(relativeDirPath).append("/").append(fileName).toString();
        String absoluteFilePath = new StringBuffer(absoluteDirPath).append("/").append(fileName).toString();

        File dir = new File(absoluteDirPath);
        if (!dir.exists())
            dir.mkdirs();
//        System.out.println(dir.getAbsolutePath());

        File file = new File(absoluteFilePath);
//        System.out.println(file.getAbsolutePath());
        try {
            if (!file.exists())
                file.createNewFile();
            uploadPic.transferTo(file);
        } catch(IOException e){
            e.printStackTrace();
        }

        postsService.updateImgPost(text, relativeFilePath, 1);
        return "redirect:/index";
    }

    @RequestMapping(value = "getTimeline", method = RequestMethod.GET)
    public @ResponseBody List<Map> getTimeline(@RequestParam int page) {
        List<Post> posts = postsService.getTimeline(1, 10*page, 10);
        List<Map> result = new ArrayList<>();
        for (Post post : posts) {
            Map map = new HashMap();
            map.put("id", post.getId());
            map.put("publisher_name", post.getPublisher().getName());
            map.put("publisher_profile_picture", post.getPublisher().getProfile_picture());
            map.put("date", post.getDate().getTime());
            map.put("text", post.getContent().getText());
            if (post.getContent() instanceof ImgContent)
                map.put("image", ((ImgContent)post.getContent()).getImgUrls());
            List<User> likes = post.getLikes();
            List like_users = new ArrayList<>();
            for (User like_user : likes) {
                Map map1 = new HashMap<>();
                map1.put("username", like_user.getName());
                like_users.add(map1);
            }
            map.put("likes", like_users);
            result.add(map);
        }
        return result;
    }

    @RequestMapping(value = "like", method = RequestMethod.GET)
    public @ResponseBody List<Map> like(@RequestParam int userid, @RequestParam int postid, @RequestParam int cancel){
        if(cancel == 0)
            postsService.likePost(userid, postid);
        else
            postsService.cancelLikePost(userid, postid);
        List<User> likes = postsService.getLikes(postid);
        List<Map> result = new ArrayList<Map>();
        for (User like_user: likes) {
            Map map = new HashMap<>();
            map.put("username", like_user.getName());
            result.add(map);
        }
        return result;
    }
}

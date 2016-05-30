package service.impl;

import data.DataMapper;
import domain.Content;
import domain.ImgContent;
import domain.Post;
import domain.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.PostsService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PostsServiceImpl implements PostsService {

    private DataMapper dataMapper;

    @Autowired
    public void setDataMapper(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    public List<Post> getTimeline(int userid, int firstResult, int maxResults) {
        RowBounds rowBounds = new RowBounds(firstResult, maxResults);
        return dataMapper.selectUserFeedPosts(userid, rowBounds);
    }

    public void updateTextPost(String text, int userid) {
        Content textContent = new Content();
        textContent.setText(text);
        dataMapper.insertTextContent(textContent);
        Date date = new Date();
        dataMapper.insertTextPost(date, textContent.getId(), userid);
    }

    public void updateImgPost(String text, String savePath, int userid) {
        ImgContent imgContent = new ImgContent();
        imgContent.setText(text);
        imgContent.setImgUrls(savePath);
        dataMapper.insertImgContent(imgContent);
        Date date = new Date();
        dataMapper.insertImgPost(imgContent.getId(), date, userid);
    }

    public void likePost(int userid, int postid) {
        dataMapper.insertPostLikes(postid, userid);
    }

    public void cancelLikePost(int userid, int postid) {
        dataMapper.deletePostLikes(postid, userid);
    }

    public List<User> getLikes(int postid) {
        Post post = dataMapper.selectPostById(postid);
        return post.getLikes();
    }

}

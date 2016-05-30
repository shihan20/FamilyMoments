package data;

import domain.Content;
import domain.ImgContent;
import domain.Post;
import domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * Created by shihan on 16/5/25.
 */
public interface DataMapper {
    User selectUserById(int id);
    User selectUserByName(String name);
    List<User> selectUserFriends(int id);
    List<Post> selectUserFeedPosts(int id, RowBounds rowBounds);
    List<User> selectLikeUsers(int id);
    Post selectPostById(int id);
    int insertTextContent(Content textContent);
    int insertTextPost( @Param("date") Date date, @Param("content_id") int content_id, @Param("publisher_id") int publisher_id);
    int insertImgContent(ImgContent imgContent);
    int insertImgPost(@Param("content_id") int content_id, @Param("date") Date date, @Param("publisher_id") int publisher_id);
    int insertPostLikes(@Param("post_id") int post_id, @Param("like_user_id") int like_user_id);
    int deletePostLikes(@Param("post_id") int post_id, @Param("like_user_id") int like_user_id);
}

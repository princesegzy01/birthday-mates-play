package finder;
import io.ebean.*;
import models.Post;
import java.util.List;

public class PostFinder extends Finder<Long, Post> {
    public PostFinder(){
        super(Post.class);
    }

    public Post byId(Integer id) {
        return query().where().eq("id", id).findOne();
    }
    public List<Post> byUser(Integer id) {
        return query().where().eq("user_id", id).findList();
    }

}

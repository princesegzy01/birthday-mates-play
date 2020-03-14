package finder;
import io.ebean.*;
import models.Post;

public class PostFinder extends Finder<Long, Post> {
    public PostFinder(){
        super(Post.class);
    }

    public Post byId(Integer id) {
        return query().where().eq("id", id).findOne();
    }
    public Post byUser(Integer id) {
//        return query().where().eq("user_id", id).findList();
        return query().where().eq("id", id).findOne();
    }

}

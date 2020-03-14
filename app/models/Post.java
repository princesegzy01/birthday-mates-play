package models;

import finder.AccountFinder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

import  finder.PostFinder;

@Entity
public class Post extends Model  {

    @Id
    @Constraints.Required
    public Long id;

    @Constraints.MaxLength(255)
    @Constraints.MinLength(5)
    public Integer user_id;
    public String content;
    public Integer status;
    public String timestamp;

    public Post(Integer user_id, String content, Integer status, String timestamp){
        this.user_id = user_id;
        this.content = content;
        this.status = status;
        this.timestamp = timestamp;
    }

    public static final PostFinder find = new PostFinder();

}

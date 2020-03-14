package controllers;

import models.Account;
import models.Post;
import play.*;
import play.mvc.*;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;


public class ApiPostController extends  Controller {


   public Result addPost(Http.Request request){

       JsonNode json = request.body().asJson();

       Integer user_id = Integer.parseInt(json.findPath("user_id").textValue());
       String content = json.findPath("content").textValue();
       Integer status = Integer.parseInt(json.findPath("status").textValue());
       String timestamp = json.findPath("timestamp").textValue();

       Post post = new Post(user_id, content, status, timestamp);
       post.save();

       ObjectNode response = Json.newObject();
       response.put("status", "success");
       response.put("msg",  "Post Successfully Added");


       return ok(response);
   }

    public Result FecthAll(){
        List<Post> posts = Post.find.all();
        return ok("return");
    }

    public Result getPostById(Integer id){
        Post posts = Post.find.byId(id);
        return ok("return");
    }

    public Result getPostByUser(Integer id){
        Post posts = Post.find.byId(id);
        return ok("return");
    }
}

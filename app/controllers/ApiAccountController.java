package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.*;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http;



import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;




public class ApiAccountController extends Controller {

    public Result create() {
        // JsonNode json = request().body().asJson();
        // User user = Json.fromJson(json, User.class);
        // user.save();
        // return ok(json);
        return ok("segun");
    }


    // login controller
    public Result login(Http.Request request){

        ObjectNode result = Json.newObject();
        result.put("exampleField1", "foobar");
        result.put("exampleField2", "Hello world!");
        
        JsonNode json = request.body().asJson();

        // System.out.println(result);
        System.out.println(json);

        return ok(result);
    }

    // Registration controller
    public Result register(){

        return ok("register");
    }

    // confirmAccount account controller
    public Result confirmAccount(){

        return ok("register");
    }

    // confirmAccount account controller
    public Result resetPassword(){

        return ok("resetPassword");
    }

    // confirmAccount account controller
    public Result changePassword(){

        return ok("changePassword");
    }



}
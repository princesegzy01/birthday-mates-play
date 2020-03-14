package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import finder.AccountFinder;
import models.Account;
import play.*;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;

import  io.ebean.Ebean;

import java.util.List;


public class ApiAccountController extends Controller {

    public Result index() {


        List<Account> accounts = Account.find.all();
//        Account accounts = Account.find.all();
        for ( Account account: accounts){
//            JsonNode accountJson = Json.toJson(account);
//            System.out.println(accountJson);
            System.out.println(account.email);
            account.delete();
        }

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
    public Result Register(Http.Request request){

        JsonNode json = request.body().asJson();

        String firstName = json.findPath("firstName").textValue();
        String lastName = json.findPath("lastName").textValue();
        String email = json.findPath("email").textValue();
        String dob = json.findPath("dob").textValue();
        String displayName = json.findPath("displayName").textValue();
        String password = json.findPath("password").textValue();

        Account accountExist = Account.find.byEmail(email);
        if(accountExist != null){
            ObjectNode response = Json.newObject();
            response.put("error", "Account with same email previously exist");
            return badRequest(response);
        }
        Account newAccount = new Account(firstName, lastName, email, dob, displayName, password);
        newAccount.save();

        ObjectNode account = Json.newObject();
        account.put("firstName", firstName);
        account.put("lastName", lastName);
        account.put("email", email);
        account.put("dob", dob);
        account.put("displayName", displayName);

        return ok(account);
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
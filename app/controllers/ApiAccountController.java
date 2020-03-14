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

        JsonNode json = request.body().asJson();
        String email = json.findPath("email").textValue();
        String password = json.findPath("password").textValue();

        Account accountExist = Account.find.byEmailPassword(email, password);
        if(accountExist == null){

            ObjectNode response = Json.newObject();
            response.put("error", "Account does not exist");
            return notFound(response);
        }


        ObjectNode response = Json.newObject();
        response.put("status", "Account successfully Logged In");
        return ok(response);
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
        account.put("id", newAccount.id);

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
    public Result ChangePassword(Http.Request request){

        JsonNode json = request.body().asJson();
        Integer id = Integer.parseInt(json.findPath("id").textValue());
        String oldPassword = json.findPath("oldPassword").textValue();
        String newPassword = json.findPath("newPassword").textValue();

        Account account = Account.find.byId(id);
        if(account != null){
            if (!account.password.trim().equals(oldPassword.trim())) {
                ObjectNode response = Json.newObject();
                response.put("error", "Old password does not match");
                return badRequest(response);
            }
            account.password = newPassword;
            account.save();

            ObjectNode response = Json.newObject();
            response.put("status", "Password Successfully changed");
            return ok(response);
        }


        return ok("changePassword");
    }



}
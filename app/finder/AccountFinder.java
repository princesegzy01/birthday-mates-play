package finder;
import io.ebean.*;
import models.Account;
import models.Post;

public class AccountFinder extends Finder<Long,Account> {
    public  AccountFinder(){
        super(Account.class);
    }

//    public Account byFirstName(String name) {
//        return query().eq("firstName", name).findOne();
//    }

    public Account byId(Integer id) {
        return query().where().eq("id", id).findOne();
    }

    public Account byEmail(String email) {
        return query().where().eq("email", email).findOne();
    }

    public Account byEmailPassword(String email, String password) {
        return query().where().eq("email", email).eq("password", password).findOne();
    }

    public Account byUser(String username) {
        return query().where().eq("userName", username).findOne();
    }



//    public List<Account> findNew() {
//        return query().where()
//                .eq("status", Customer.Status.NEW)
//                .orderBy("name")
//                .findList();
//    }

}

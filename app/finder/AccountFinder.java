package finder;
import io.ebean.*;
import models.Account;

public class AccountFinder extends Finder<Long,Account> {
    public  AccountFinder(){
        super(Account.class);
    }

//    public Account byFirstName(String name) {
//        return query().eq("firstName", name).findOne();
//    }
//
//    public Account byLastName(String name) {
//        return query().eq("firstName", name).findOne();
//    }
//
    public Account byEmail(String email) {
        return query().where().eq("email", email).findOne();
    }

//    public List<Account> findNew() {
//        return query().where()
//                .eq("status", Customer.Status.NEW)
//                .orderBy("name")
//                .findList();
//    }

}

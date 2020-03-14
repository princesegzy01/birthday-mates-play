package models;

import finder.AccountFinder;
import  io.ebean.Model;

import javax.persistence.Entity;
import play.data.validation.Constraints;
import javax.validation.constraints.Max;
import javax.persistence.Id;

@Entity
public class Account extends Model  {

    @Id
    @Constraints.Required
    public Long id;

    @Constraints.MaxLength(255)
    @Constraints.MinLength(5)
    public String firstName;
    public String lastName;
    public String email;
    public String displayName;
    public String password;
    public String dob;

    public Account(String firstName, String lastName, String email, String dob, String displayName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.displayName = displayName;
        this.password = password;
    }

    public static final AccountFinder find = new AccountFinder();


//    public static Finder<Integer, Account> find  = new Finder<>(Account.class);
//    public static Finder<Integer,Account> find = new Finder<>(Account.class);
//    public static final Finder<Long, Account> find = new Finder<>(Account.class);
//    public static final Find find = new Finder<>(Account.class);
}

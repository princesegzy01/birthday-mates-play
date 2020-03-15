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
    public String userName;
    public String email;
    public String displayName;
    public String password;
    public String dob;

    public Account(String userName, String email, String dob, String displayName, String password){
        this.userName = userName;
        this.email = email;
        this.dob = dob;
        this.displayName = displayName;
        this.password = password;
    }

    public static final AccountFinder find = new AccountFinder();

}

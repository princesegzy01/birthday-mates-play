package models;

import  io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account extends Model  {

    @Id
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String dob;

    public Account(Long id, String firstName, String lastName, String email, String dob){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }
}

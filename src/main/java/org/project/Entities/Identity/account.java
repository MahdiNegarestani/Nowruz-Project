package org.project.Entities.Identity;

import org.project.Entities.entity;

public class account extends entity{
    protected String Name;
    protected String Username;
    protected String Password;
    protected String Email;
    protected int Age;

    public account() {}

    public account(String name, String username, String password, String email, int age) {
        Name = name;
        Username = username;
        Password = password;
        Email = email;
        Age = age;
    }

    public String getName() {return this.Name;}

    public String getUsername() {return this.Username;}

    public String getEmail() {return this.Email;}

    public String getPassword() {return this.Password;}

    public int getAge() {return this.Age;}

    public void setName(String Name) {this.Name = Name;}

    public void setUsername(String Username) {this.Username = Username;}

    public void setEmail(String Email) {this.Email = Email;}

    public void setPassword(String Password) {this.Password = Password;}

    public void setAge(int Age) {this.Age = Age;}
}
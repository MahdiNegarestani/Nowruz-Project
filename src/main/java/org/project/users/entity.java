package org.project.Accounts;

public class account {
    private String Username;
    private String Password;
    private String Email;
    private role Role;
    private int age;

    public account(int age, String email, String password, String username, role role) {
        this.Email = email;
        this.Password = password;
        this.Username = username;
        this.Role = role;
        this.age = age;
    }
}
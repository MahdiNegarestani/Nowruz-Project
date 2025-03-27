package org.project.entity;

public class entity {
    private String Username;
    private String Password;
    private String Email;
    private role Role;

    public entity(String email, String password, String username, role role) {
        this.Email = email;
        this.Password = password;
        this.Username = username;
        this.Role =  role;
    }
}
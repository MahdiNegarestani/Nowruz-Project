package org.project.Roles;

public abstract class role {
    protected String name;
    protected String username;
    protected String email;

    public role(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getName() {return this.name;}

    public String getUsername() {return this.username;}

    public String getEmail() {return this.email;}

    public abstract void displayRoleInfo();

}
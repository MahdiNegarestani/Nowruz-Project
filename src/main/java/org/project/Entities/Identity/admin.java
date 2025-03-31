package org.project.Entities.Identity;

import org.project.Enums.*;

public class admin extends account{

    public admin() {Role = roles.ADMIN;}

    public admin(String name, String username, String password, String email, int age, roles role) {
        super(name, username, password, email, age, role);
    }
}
package org.project.Entities.Identity;

import org.project.Enums.*;
import org.project.Entities.Music.*;
import org.project.Services.Music.*;

public class artist extends account {

    public artist() {Role = roles.ARTIST;}

    public artist(String name, String username, String password, String email, int age, roles role) {
        super(name, username, password, email, age, role);
    }
}
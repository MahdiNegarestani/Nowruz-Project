package org.project.Entities.Identity;

import org.project.Entities.Music.comment;
import org.project.Entities.Music.song;
import org.project.Enums.*;

import java.time.LocalDateTime;

public class admin extends account{

    public admin() {
        super();
        Role = roles.ADMIN;
    }

    public admin(String name, String username, String password, String email, int age, roles role) {
        super(name, username, password, email, age, role);
    }
}
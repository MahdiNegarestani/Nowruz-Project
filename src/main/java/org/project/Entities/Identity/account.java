package org.project.Entities.Identity;

import org.project.Entities.Music.comment;
import org.project.Entities.Music.song;
import org.project.Entities.entity;
import org.project.Enums.*;

import java.time.LocalDateTime;

public class account extends entity{
    protected String Name;
    protected String Username;
    protected String Password;
    protected String Email;
    protected int Age;
    protected roles Role;

    public account() {}

    public account(String name, String username, String password, String email, int age, roles role) {
        Name = name;
        Username = username;
        Password = password;
        Email = email;
        Age = age;
        Role = role;
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

    public roles getRole() {return this.Role;}

    public comment leaveComment(song song, String comment) {
        comment comment1 = new comment();
        comment1.setContent(comment);
        comment1.setUserId(getId());
        comment1.setSongId(song.getId());
        comment1.setReleaseDate(LocalDateTime.now());
        return comment1;
    }
}
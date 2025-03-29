package org.project.Services.Identity;

import org.project.Services.*;
import org.project.Entities.Identity.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;

public class userService implements service_interface<user> {

    private final dataStorage dataStorage;

    public userService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public user getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                if (id == account.getUsername()){
                    return (user)account;
                }
            }
        }
        return null;
    }

    public void add(user u) {
        dataStorage.Accounts.add(u);
    }

    public void edit(user u) {
        dataStorage.Accounts.set(dataStorage.Accounts.indexOf(u), u);
    }

    public void delete(user u) {
        dataStorage.Accounts.remove(dataStorage.Accounts.indexOf(u));
    }

    public ArrayList<user> getAll() {
        ArrayList<user> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                all.add((user)account);
            }
        }
        return all;
    }
}
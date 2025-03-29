package org.project.Services.Identity;

import org.project.Services.*;
import org.project.Entities.Identity.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;

public class adminService implements service_interface<admin> {

    private final dataStorage dataStorage;

    public adminService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public admin getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                if (id == account.getUsername()){
                    return (admin) account;
                }
            }
        }
        return null;
    }

    public void add(admin u) {
        dataStorage.Accounts.add(u);
    }

    public void edit(admin u) {
        dataStorage.Accounts.set(dataStorage.Accounts.indexOf(u), u);
    }

    public void delete(admin u) {
        dataStorage.Accounts.remove(dataStorage.Accounts.indexOf(u));
    }

    public ArrayList<admin> getAll() {
        ArrayList<admin> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof admin){
                all.add((admin) account);
            }
        }
        return all;
    }
}
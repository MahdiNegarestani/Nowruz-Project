package org.project.Services.Identity;

import org.project.Services.*;
import org.project.Entities.Identity.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;

public class artistService implements service_interface<artist> {

    private final dataStorage dataStorage;

    public artistService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public artist getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                if (id == account.getUsername()){
                    return (artist) account;
                }
            }
        }
        return null;
    }

    public void add(artist u) {
        dataStorage.Accounts.add(u);
    }

    public void edit(artist u) {
        dataStorage.Accounts.set(dataStorage.Accounts.indexOf(u), u);
    }

    public void delete(artist u) {
        dataStorage.Accounts.remove(dataStorage.Accounts.indexOf(u));
    }

    public ArrayList<artist> getAll() {
        ArrayList<artist> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
                all.add((artist) account);
            }
        }
        return all;
    }
}
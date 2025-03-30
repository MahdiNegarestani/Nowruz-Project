package org.project.Services.Identity;

import org.project.Services.*;
import org.project.Entities.Identity.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class artistService implements service_interface<artist>, searchService_interface<artist> {

    private final dataStorage dataStorage;

    public artistService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public artist getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
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

    public ArrayList<artist> getBySearch(String search) {
        ArrayList<artist> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
                if (Objects.equals(search, account.getName())){
                    all.add((artist)account);
                }
            }
        }
        return all;
    }
}
package org.project.Services.Identity;

import org.project.DataStorage.dataStorage;
import org.project.Entities.Identity.account;
import org.project.Entities.Identity.*;
import org.project.Enums.roles;
import org.project.IDR;


public class accountManager implements accountManager_interface{

    private final dataStorage dataStorage;

    public accountManager(dataStorage dataStorage) {this.dataStorage = dataStorage;}

    public boolean checkUsernameAvailability(String username) {
        boolean isTaken = false;
        for (account account:dataStorage.Accounts){
            if (username.equals(account.getUsername())){isTaken = true; break;}
        }
        return isTaken;
    }

    public account GetAccountByUsername(String username) {
        for (account account:dataStorage.Accounts){
            if (username.equals(account.getUsername())){return account;}
        }
        System.out.println("invalid username");
        return null;
    }

    public account Login(String username, String password) {
        account account = GetAccountByUsername(username);
        if (account == null) {return null;}
        else if (password.equals(account.getPassword())){return account;}
        else {
            System.out.println("Wrong password! Try again");
            return null;
        }
    }

    public account GetAccountById(String accountId) {
        for (account account:dataStorage.Accounts){
            if (accountId.equals(account.getId())){return account;}
        }
        return null;
    }

    public void EditAccount(account account) {
        for (int i = 0; i < dataStorage.Accounts.size(); i++){
            if (account.getId().equals(dataStorage.Accounts.get(i).getId())) {
                dataStorage.Accounts.set(i, account);
            }
        }
    }

    public void DeleteAccount(String accountId) {
        for (account account:dataStorage.Accounts){
            if (accountId.equals(account.getId())){dataStorage.Accounts.remove(account);}
        }
    }

    public IDR signup(String name, String username, String password, String email, int age, roles role){
        if (checkUsernameAvailability(username)){
            return IDR.creatFailedIDR("username is already taken");
        }
        account account = null;
        switch (role) {
            case USER: {account = new user();
                break;}
            case ADMIN: {account = new admin();
                break;}
            case ARTIST: {account = new artist();
                break;}
        }
        account.setPassword(password);
        account.setUsername(username);
        account.setEmail(email);
        account.setAge(age);
        account.setName(name);
        dataStorage.AccountsRegisterd.add(account);
        return IDR.creatSeccesIDR("Account successfully registered! waiting for approval");
    }

    public IDR ChangePassword(String accountId, String newPassword) {
        account account = GetAccountById(accountId);
        if (account == null){
            return IDR.creatFailedIDR("Account not found");
        }
        account.setPassword(newPassword);
        return IDR.creatSeccesIDR("Password successfully changed!");
    }
}
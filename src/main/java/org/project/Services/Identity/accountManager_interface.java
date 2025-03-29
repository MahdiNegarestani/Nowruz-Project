package org.project.Services.Identity;

import org.project.Entities.Identity.account;
import org.project.Enums.roles;
import org.project.IDR;

public interface accountManager_interface {
    boolean checkUsernameAvailability(String username);
    IDR register(account account, String password);
    account Login(String username, String password);
    void EditAccount(account account);
    void DeleteAccount(String accountId);
    IDR ChangePassword(String accountId, String newPassword);
    account GetAccountById(String accountId);
    account GetAccountByUsername(String username);
}
package main.dependancy_injection.service.impl;

import main.dependancy_injection.lib.Inject;
import main.dependancy_injection.model.User;
import main.dependancy_injection.service.AccountService;
import main.dependancy_injection.service.AuthenticationManager;

public class AuthenticationManagerImpl implements AuthenticationManager {
    @Inject
    private AccountService accountService;
    @Inject
    private User currentUser;
    @Override
    public boolean hasPermission(String accountNumber) {
        return false;
    }
}

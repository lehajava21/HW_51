package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.provider.Provider;

public class GetAllUsers extends MenuItem {

    private Provider provider;

    public GetAllUsers(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    @Override
    public boolean perform() {
        Object o = provider.getAllUsers();
        return showAllUsers(o);
    }
}

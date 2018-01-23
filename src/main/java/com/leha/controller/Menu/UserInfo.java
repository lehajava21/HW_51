package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.provider.Provider;

public class UserInfo extends MenuItem {

    private Provider provider;

    public UserInfo(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    public boolean perform() {
        return true;
    }
}

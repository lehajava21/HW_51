package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.provider.Provider;
import org.springframework.http.HttpStatus;

public class Logout extends MenuItem {

    private Provider provider;

    public Logout(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    public boolean perform() {
        Object o = provider.logout();
        HttpStatus status = (HttpStatus) o;
        System.out.println("Logout code: " + status.toString());
        return false;
    }
}

package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.provider.Provider;

public class GetItems extends MenuItem {

    private Provider provider;

    public GetItems(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    @Override
    public boolean perform() {
        return false;
    }
}

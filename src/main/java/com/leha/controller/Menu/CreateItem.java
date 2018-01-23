package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.provider.Provider;

public class CreateItem extends MenuItem {

    private Provider provider;

    public CreateItem(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    @Override
    public boolean perform() {
        return false;
    }
}

package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.provider.Provider;

import java.util.Scanner;

public class GetUserById extends MenuItem {

    private Provider provider;

    public GetUserById(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    @Override
    public boolean perform() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id:");
        String inp = scanner.nextLine();
        Object o = provider.getUserById(inp);
        return showUser(o);
    }
}

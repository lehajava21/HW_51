package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.model.LoginRequest;
import com.leha.provider.Provider;

import java.util.Scanner;

public class Login extends MenuItem {

    private Provider provider;

    public Login(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    public boolean perform() {

        Scanner scanner = new Scanner(System.in);
        String inp;
        LoginRequest request = new LoginRequest();
        System.out.println("Enter email:");
        inp = scanner.nextLine();
        request.setEmail(inp);
        System.out.println("Enter password:");
        inp = scanner.nextLine();
        request.setPassword(inp);
        Object o = provider.login(request);
        return showRegistration(o);
    }
}

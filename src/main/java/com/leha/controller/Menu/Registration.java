package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.model.RegistrationRequest;
import com.leha.provider.Provider;

import java.util.Scanner;

public class Registration extends MenuItem{

    private Provider provider;

    public Registration(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    public boolean perform() {

        Scanner scanner = new Scanner(System.in);
        String inp;
        RegistrationRequest request = new RegistrationRequest();
        System.out.println("Enter first name:");
        inp = scanner.nextLine();
        request.setFirstName(inp);
        System.out.println("Enter last name:");
        inp = scanner.nextLine();
        request.setLastName(inp);
        System.out.println("Enter email:");
        inp = scanner.nextLine();
        request.setEmail(inp);
        System.out.println("Enter password:");
        inp = scanner.nextLine();
        request.setPassword(inp);
        Object o = provider.register(request);
        return showRegistration(o);
    }
}

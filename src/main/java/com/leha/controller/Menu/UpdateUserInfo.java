package com.leha.controller.Menu;

import com.leha.controller.MenuItem;
import com.leha.model.UpdateRequest;
import com.leha.provider.Provider;

import java.util.Scanner;

public class UpdateUserInfo extends MenuItem{

    private Provider provider;

    public UpdateUserInfo(String mes) {
        super(mes);
        provider = Provider.getInstance();
    }

    public boolean perform() {
        Scanner scanner = new Scanner(System.in);
        String inp;
        System.out.println("Enter user id:");
        inp = scanner.nextLine();
        String id = inp;
        Object o = provider.getUserById(inp);
        showUser(o);
        UpdateRequest request = new UpdateRequest();
        System.out.println("Enter first name:");
        inp = scanner.nextLine();
        request.setFirstName(inp);
        System.out.println("Enter last name:");
        inp = scanner.nextLine();
        request.setLastName(inp);
        System.out.println("Enter email:");
        inp = scanner.nextLine();
        request.setEmail(inp);
        o = provider.updateUser(request,id);
        return showUpdate(o);
    }
}

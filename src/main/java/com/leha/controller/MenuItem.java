package com.leha.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leha.model.OuterErrorResponce;
import com.leha.model.RegistrationResponse;
import com.leha.model.UserWeb;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class MenuItem {

    private final String prompt = "Select the menu item or 'q' to exit:";
    private String mes;
    private List<MenuItem> items;

    public MenuItem() {
    }

    public MenuItem(String mes) {
        this.mes = mes;
    }

    public void add(MenuItem item){
        if(items == null){
            items = new ArrayList<MenuItem>();
        }
        items.add(item);
    }

    public void execute() {
        if(!perform()){
            return;
        }
        if(items != null) {
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println(prompt);
                for(int i = 0; i < items.size(); i++){
                    String imes = items.get(i).mes;
                    if(imes != null){
                        System.out.println(i+1 + " " + items.get(i).mes);
                    }
                }
                String inp = scanner.nextLine();
                if(inp.equals("q")){
                    break;
                }
                int it;
                try {
                    it = Integer.parseInt(inp);
                }catch (Exception e){
                    continue;
                }
                if(it > 0 && it <= items.size() ){
                    items.get(it-1).execute();
                }
            }
        }
    }

    public boolean showRegistration(Object o){
        try {
            RegistrationResponse response = (RegistrationResponse) o;
            System.out.println(response.getUser().getFirstName() + " "
                    + response.getUser().getLastName());
        }catch (Exception e){
            return showError(o);
        }
        return true;
    }

    @SneakyThrows
    public boolean showAllUsers(Object o){
        try {
            String body = (String) o;
            List<UserWeb> users = new ObjectMapper()
                    .readValue(body,new TypeReference<List<UserWeb>>(){});
            for(UserWeb user : users){
                System.out.println(user.getFirstName() + " "
                        + user.getLastName() + " "
                        + user.getEmail() + "\t" + user.getId());
            }
        }catch (Exception e){
            return showError(o);
        }
        return true;
    }

    public boolean showUser(Object o){
        try {
            String body = (String) o;
            Map<String,String> map = new ObjectMapper()
                    .readValue(body,new TypeReference<Map<String,String>>(){});
            System.out.println(map.get("firstName") + " " + map.get("lastName") + " "
                    + map.get("email"));
        }catch (Exception e){
            return showError(o);
        }
        return true;
    }

    public boolean showUpdate(Object o){
        try {
            UserWeb user = (UserWeb)o;
            System.out.println(user.getFirstName() + "\t" + user.getLastName() + "\t"
                + user.getEmail() + "\t");
        }catch (Exception e){
            return showError(o);
        }
        return true;
    }

    private boolean showError(Object o){
        OuterErrorResponce responce = (OuterErrorResponce) o;
        System.out.println("Error: " + responce.getErrorStatus() + " "
                + responce.getMessage());
        return false;
    }

    public abstract boolean perform();
}

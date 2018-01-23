package com.leha.controller.Menu;

import com.leha.controller.MenuItem;

public class MainMenu extends MenuItem{

    public MainMenu() {
        super();

        MenuItem registration = new Registration("Registration");
        MenuItem login = new Login("Login");
        this.add(registration);
        this.add(login);

        MenuItem userInfo = new UserInfo("User info");
        MenuItem itemManagement = new ItemManagement("Item management");
        MenuItem logout = new Logout("Logout");
        registration.add(userInfo);
        registration.add(itemManagement);
        registration.add(logout);
        login.add(userInfo);
        login.add(itemManagement);
        login.add(logout);

        MenuItem getUserInfo = new GetUserInfo("Get user info");
        MenuItem updateUserInfo = new UpdateUserInfo("Update user info");
        userInfo.add(getUserInfo);
        userInfo.add(updateUserInfo);

        MenuItem getAllUsers = new GetAllUsers("Get all users");
        MenuItem getUserById = new GetUserById("Get user by id");
        getUserInfo.add(getAllUsers);
        getUserInfo.add(getUserById);

        MenuItem createItem = new CreateItem("Create item");
        MenuItem getItems = new GetItems("Get items");
        itemManagement.add(createItem);
        itemManagement.add(getItems);

    }

    public boolean perform() {
        return true;
    }
}

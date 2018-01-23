package com.leha;

import com.leha.controller.Menu.MainMenu;
import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(String[] args){
        new MainMenu().execute();
    }

}

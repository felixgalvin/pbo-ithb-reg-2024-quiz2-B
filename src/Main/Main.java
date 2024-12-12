package Main;

import Controller.Login;
import View.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        new Login(loginView);
    }
}
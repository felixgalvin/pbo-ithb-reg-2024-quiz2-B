package Controller;

import View.BookView;
import View.LoginView;
import Model.classes.*;

public class Login {
    private LoginView loginView;

    public Login(LoginView loginView) {
        this.loginView = loginView;

        this.loginView.getLoginButton().addActionListener(e -> cekLogin());
    }

    public void cekLogin() {
        String email = loginView.getEmail();
        String pass = loginView.getPassword();
        
        boolean isValid = false;
        
        if (Users.cekLogin(email, pass)) {
            isValid = true;
            loginView.showMessage("Login berhasil! Selamat datang, " + email);
            loginView.dispose();
            new BookView();
        }

        if (!isValid) {
            loginView.showMessage("Login gagal. Periksa kembali email/password Anda");
            loginView.dispose();
            new LoginView();
        }
    }
}

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel frame;
    private JPanel input, headerPanel, button;
    private JLabel header, email, password;
    private JTextField userValue;
    private JPasswordField passwordValue;
    private JButton login;

    public LoginView() {
        super("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        frame = new JPanel(new GridBagLayout());
        frame.setBackground(Color.DARK_GRAY);

        headerPanel = new JPanel();
        headerPanel.setOpaque(false);

        input = new JPanel(new GridLayout(3, 1, 10, 10));
        input.setOpaque(false);

        button = new JPanel();
        button.setOpaque(false);

        header = new JLabel("Selamat Datang, silahkan input data di bawah ini!");
        header.setFont(new Font("Arial", Font.PLAIN, 30));
        header.setForeground(Color.WHITE);

        email = new JLabel("Email        :");
        email.setFont(new Font("Arial", Font.PLAIN, 16));
        email.setForeground(Color.WHITE);

        password = new JLabel("Password  :");
        password.setFont(new Font("Arial", Font.PLAIN, 16));
        password.setForeground(Color.WHITE);

        userValue = new JTextField();
        userValue.setPreferredSize(new Dimension(300, 40));
        userValue.setFont(new Font("Arial", Font.PLAIN, 16));
        userValue.setBackground(Color.RED);
        userValue.setForeground(Color.WHITE);

        passwordValue = new JPasswordField();
        passwordValue.setPreferredSize(new Dimension(300, 40));
        passwordValue.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordValue.setBackground(Color.RED);
        passwordValue.setForeground(Color.WHITE);

        login = new JButton("LOGIN");
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBackground(Color.RED);
        login.setForeground(Color.WHITE);

        headerPanel.add(header);
        input.add(email);
        input.add(userValue);
        input.add(password);
        input.add(passwordValue);
        button.add(login);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.gridwidth = 1;  
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(headerPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2; 
        gbc.gridwidth = 1;  
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3; 
        gbc.gridwidth = 1;  
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(button, gbc);

        add(frame);

        setVisible(true);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = getEmail();
                System.out.println("Email : " + email + "\nBerhasil login");
            }
        });
    }

    public String getEmail() {
        return userValue.getText();
    }

    public String getPassword() {
        return new String(passwordValue.getPassword());
    }

    public JButton getLoginButton() {
        return login;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

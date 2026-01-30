import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    JTextField loginField;
    JPasswordField hasloField;
    JButton loginButton;
    JLabel statusLabel;

    public View() {
        setTitle("Logowanie");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        loginField = new JTextField();
        hasloField = new JPasswordField();
        loginButton = new JButton("Zaloguj");
        statusLabel = new JLabel(" ");

        add(new JLabel("Login:"));
        add(loginField);
        add(new JLabel("Hasło:"));
        add(hasloField);
        add(loginButton);
        add(statusLabel);
    }
}

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            UserModel model = new UserModel();
            new Controller(view, model);
            view.setVisible(true);
        });
    }
}

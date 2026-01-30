import javax.swing.*;

public class Controller {

    private View view;
    private UserModel model;

    public Controller(View view, UserModel model) {
        this.view = view;
        this.model = model;

        view.loginButton.addActionListener(e -> zaloguj());
    }

    private void zaloguj() {
        String user = view.loginField.getText();
        String pass = new String(view.hasloField.getPassword());

        view.loginButton.setEnabled(false);
        view.statusLabel.setText("Trwa weryfikacja danych...");

        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {

            @Override
            protected Boolean doInBackground() {
                return model.walidujLogowanie(user, pass);
            }

            @Override
            protected void done() {
                try {
                    boolean wynik = get();
                    if (wynik) {
                        view.statusLabel.setText("Logowanie pomyślne!");
                    } else {
                        view.statusLabel.setText("Błędny login lub hasło!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                view.loginButton.setEnabled(true);
            }
        };

        worker.execute();
    }
}

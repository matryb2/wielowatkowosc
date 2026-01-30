import javax.swing.*;
import java.awt.*;

public class NotWorkingApp extends JFrame {

    private JLabel statusLabel;
    private JButton startButton;

    public NotWorkingApp() {
        setTitle("Wersja Zawieszająca");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        statusLabel = new JLabel("Status: gotowy");
        startButton = new JButton("Start");

        startButton.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                statusLabel.setText("Pracuję... " + (i + 1) + "s");
            }
            statusLabel.setText("Zakończono blokadę.");
        });

        add(startButton);
        add(statusLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NotWorkingApp().setVisible(true);
        });
    }
}

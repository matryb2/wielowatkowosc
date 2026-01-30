import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkingApp extends JFrame {

    private JLabel statusLabel;
    private JButton startButton;

    public WorkingApp() {
        setTitle("Wersja Naprawiona - SwingWorker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        statusLabel = new JLabel("Status: gotowy");
        startButton = new JButton("Start");

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);

            SwingWorker<Void, String> worker = new SwingWorker<>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        publish("Pracuję... " + (i + 1) + "s");
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    statusLabel.setText(chunks.get(chunks.size() - 1));
                }

                @Override
                protected void done() {
                    statusLabel.setText("Zakończono pomyślnie!");
                    startButton.setEnabled(true);
                }
            };

            worker.execute();
        });

        add(startButton);
        add(statusLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WorkingApp().setVisible(true);
        });
    }
}

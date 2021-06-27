import javax.swing.*;

public class Test {
    private JFrame window;
    public Test() {
        window = new JFrame("DV Timer");
        window.setSize(280, 350);
        window.setLocationRelativeTo(null);
        window.add(new Panel());
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    public static void main(String... arg) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}

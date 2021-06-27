import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener{
    private JButton[] buttons = new JButton[10];
    public static  JLabel label = new JLabel("00 : 00");
    private JButton but0 = new JButton("0");
    private JButton startBut = new JButton("START");
    private JButton deleteBut = new JButton("STOP");
    public static int counter = 0;
    public static int nums = 0;

    public Panel() {
        setLayout(null);
        class RoundedBorder implements Border {

            private int radius;


            RoundedBorder(int radius) {
                this.radius = radius;
            }


            public Insets getBorderInsets(Component c) {
                return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
            }


            public boolean isBorderOpaque() {
                return true;
            }


            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.drawRoundRect(x, y, width-1, height-1, radius, radius);
            }
        }
        label.setBounds(57, 15, 170, 60);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 50));
        label.setForeground(Color.WHITE);
        add(label);

        for(int i = 0; i < 3; i++) {
            for( int j = 0; j < 3; j++) {
                buttons[i * 3 + j + 1] = new JButton((j * 3 + i + 1) + "");
                buttons[i * 3 + j + 1].setBounds(i * (50 + 10) + 50, j * (50 + 10) + 80, 50, 50);
                buttons[i * 3 + j + 1].setBorder(new RoundedBorder(15));
                buttons[i * 3 + j + 1].setBackground(Color.DARK_GRAY);
                buttons[i * 3 + j + 1].setCursor(new Cursor(12));
                buttons[i * 3 + j + 1].setForeground(Color.WHITE);
                buttons[i * 3 + j + 1].addActionListener((ActionListener) this);
                add(buttons[i * 3 + j + 1]);
            }
        }
        but0.setBounds(110, 260, 50, 50);
        but0.setBorder(new RoundedBorder(15));
        but0.setCursor(new Cursor(12));
        but0.setBackground(Color.DARK_GRAY);
        but0.setForeground(Color.WHITE);
        but0.addActionListener((ActionListener) this);
        add(but0);
        deleteBut.setBounds(20, 260, 80, 50);
        deleteBut.setCursor(new Cursor(12));
        deleteBut.setBackground(new Color(225, 92, 92));
        deleteBut.setForeground(Color.WHITE);
        deleteBut.addActionListener((ActionListener) this);
        add(deleteBut);

        startBut.setBounds(170, 260, 80, 50);
        startBut.setCursor(new Cursor(12));
        startBut.setBackground(new Color(108, 149, 241));
        startBut.setForeground(Color.WHITE);
        startBut.addActionListener((ActionListener) this);
        add(startBut);

        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter != 4 && !e.getSource().equals(startBut) && !e.getSource().equals(deleteBut)) {
            nums = nums * 10 +
                    Integer.parseInt(Character.toString(
                            e.getSource().toString().charAt(e.getSource().toString().indexOf("text") + 5)));
            label.setText( nums / 1000 + "" + nums / 100 % 10 + " : " + nums / 10 % 10 + nums % 10);
            counter++;
        }
        if(e.getSource().equals(startBut)) {
            TimerThread td = new TimerThread(nums);
            td.start();
            counter = 4;
        }
        if(e.getSource().equals(deleteBut)) {
            TimerThread.min = 0;
            TimerThread.sec = 0;
            counter = 0;
            nums = 0;
        }
    }
}

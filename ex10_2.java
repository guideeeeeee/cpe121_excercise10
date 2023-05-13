import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ex10_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Excercise10_02");
        JPanel mainpanel = new JPanel();
        CirclePanel circle = new CirclePanel();

        // set circle
        circle.setFocusable(true);
        circle.addKeyListener(new KeyAdapter() {
            int posx = 0;
            int posy = 0;

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    posy -= 10;
                    mainpanel.setLocation(posx, posy);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    posy += 10;
                    mainpanel.setLocation(posx, posy);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    posx -= 10;
                    mainpanel.setLocation(posx, posy);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    posx += 10;
                    mainpanel.setLocation(posx, posy);
                }
            }
        });
        
        // set mainPanel
        mainpanel.add(circle);

        // setting
        frame.add(mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);

        circle.requestFocusInWindow(); // set the focus to the circle panel
    }
}

class CirclePanel extends JPanel {
    private int radius = 5;
    private int x = 0;
    private int y = 0;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(x, y, 2 * radius, 2 * radius);
    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

class ClockAnimation extends JFrame {
    private Clock clock = new Clock();
    private Timer timer;

    public ClockAnimation() {
        add(clock);

        timer = new Timer(1000, new TimerListener());
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clock.setCurrentTime();
            clock.repaint();
        }
    }
}

public class ex10_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise10_04");
        Clock clock = new Clock();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //setbutton
        JPanel butpanel = new JPanel();
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        //add
        butpanel.add(start);
        butpanel.add(stop);
        mainPanel.add(butpanel,BorderLayout.SOUTH);

        mainPanel.add(clock, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setVisible(true);

    }
}

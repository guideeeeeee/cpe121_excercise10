import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;

class ClockAnimation extends JPanel {
    private Clock clock = new Clock();
    Timer timer = new Timer(1000, new TimerListener());
    public ClockAnimation() {
        add(clock);
    }
    public void start(){
        timer.start();
    }
    public void stop(){
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
        ClockAnimation clock = new ClockAnimation();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //setbutton
        JPanel butpanel = new JPanel();
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        //add
        butpanel.add(start);
        butpanel.add(stop);

        //logic 
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                clock.start();
            }
        });
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                clock.stop();
            }
        });
        mainPanel.add(butpanel,BorderLayout.SOUTH);

        mainPanel.add(clock, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setVisible(true);

    }
}

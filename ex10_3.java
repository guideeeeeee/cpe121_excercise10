import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ex10_3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise10_03");
        JPanel mainpanel = new JPanel(new BorderLayout());

        // set top
        JPanel topPanel = new JPanel();
        // set button
        JRadioButton red = new JRadioButton("red");
        JRadioButton yellow = new JRadioButton("Yellow");
        JRadioButton white = new JRadioButton("White");
        JRadioButton gray = new JRadioButton("Gray");
        JRadioButton green = new JRadioButton("Green");

        // Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(red);
        group.add(yellow);
        group.add(white);
        group.add(gray);
        group.add(green);

        // add
        topPanel.add(red);
        topPanel.add(yellow);
        topPanel.add(white);
        topPanel.add(gray);
        topPanel.add(green);
        mainpanel.add(topPanel, BorderLayout.NORTH);

        // set center
        JPanel centerPanel = new JPanel();

        // set south
        JPanel southPanel = new JPanel();
        JRadioButton rec = new JRadioButton("Rectangle");
        JRadioButton oval = new JRadioButton("Oval");

        // Group radio buttons
        ButtonGroup groupdown = new ButtonGroup();
        groupdown.add(rec);
        groupdown.add(oval);

        southPanel.add(rec);
        southPanel.add(oval);

        // set logic
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.red);
            }
        });
        yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.yellow);
            }
        });
        white.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.white);
            }
        });
        gray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.gray);
            }
        });
        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.setBackground(Color.green);
            }
        });
        //
        FigurePanel figure = new FigurePanel();
        centerPanel.add(figure);

        rec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                figure.paintRectangle();
                centerPanel.add(figure);
                centerPanel.revalidate();
                centerPanel.repaint();
            }
        });

        oval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                figure.paintOval();
                centerPanel.add(figure);
                centerPanel.revalidate();
                centerPanel.repaint();
            }
        });

        // add
        mainpanel.add(centerPanel, BorderLayout.CENTER);

        // add
        mainpanel.add(southPanel, BorderLayout.SOUTH);
        frame.add(mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setVisible(true);
    }

}

class FigurePanel extends JPanel {

    private boolean isRectangle;

    public FigurePanel() {
        isRectangle = true;
    }

    public void paintRectangle() {
        isRectangle = true;
        repaint();
    }

    public void paintOval() {
        isRectangle = false;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (isRectangle) {
            g.drawRect(50, 0, 400, 180);
        } else {
            g.drawOval(50, 0, 400, 180);
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

}
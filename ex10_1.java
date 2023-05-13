import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex10_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Excercise10_01");
        JPanel mainpanel = new JPanel();

        // set text field
        JPanel toppanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toppanel.add(new JLabel("Number 1"));
        JTextField input1 = new JTextField(5);
        toppanel.add(input1);
        toppanel.add(new JLabel("Number 2"));
        JTextField input2 = new JTextField(5);
        toppanel.add(input2);
        toppanel.add(new JLabel("Result"));
        JTextField textbox = new JTextField(5);
        textbox.setEditable(false);
        toppanel.add(textbox);
        // set result
        double result = 0;
        textbox.setText(Double.toString(result));

        //set button and panel
        JPanel buttomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton add = new JButton("ADD");
        JButton subtract = new JButton("Subtract");
        JButton mutiply = new JButton("Mutiply");
        JButton divide = new JButton("Divide");
        buttomPanel.add(add);
        buttomPanel.add(subtract);
        buttomPanel.add(mutiply);
        buttomPanel.add(divide);

        //set logic button
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                double no1 = Double.parseDouble(input1.getText());
                double no2 = Double.parseDouble(input2.getText());
                double answer = no1+no2;
                textbox.setText(Double.toString(answer));
            }
        });
        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                double no1 = Double.parseDouble(input1.getText());
                double no2 = Double.parseDouble(input2.getText());
                double answer = no1-no2;
                textbox.setText(Double.toString(answer));
            }
        });
        mutiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                double no1 = Double.parseDouble(input1.getText());
                double no2 = Double.parseDouble(input2.getText());
                double answer = no1*no2;
                textbox.setText(Double.toString(answer));
            }
        });
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                double no1 = Double.parseDouble(input1.getText());
                double no2 = Double.parseDouble(input2.getText());
                double answer = no1/no2;
                String formattedAnswer = String.format("%.2f", answer);
                textbox.setText(formattedAnswer);
            }
        });
        // set mainpanel
        mainpanel.add(toppanel);
        mainpanel.add(buttomPanel);
        // setting
        frame.add(mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
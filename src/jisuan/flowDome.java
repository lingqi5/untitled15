package jisuan;

import javax.swing.*;
import java.awt.*;

public class flowDome {
    public static void main(String[] args) {
        JFrame frame=new JFrame("1111");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
        frame.add(new JButton("but1"));
        frame.add(new JButton("but2"));
        frame.add(new JButton("but3"));
        frame.add(new JButton("but4"));
        frame.add(new JButton("but5"));
        frame.setLocation(700,450);
        frame.setSize(350,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


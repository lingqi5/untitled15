package jisuan;

import javax.swing.*;
import java.awt.*;

public class BorderDome {
        public static void main(String[] args) {
            JFrame f=new JFrame("2222");
            f.setLayout(new BorderLayout());
            JButton but1=new JButton("东部");
            JButton but2=new JButton("西部");
            JButton but3=new JButton("北部");
            JButton but4=new JButton("南部");
            JButton but5=new JButton("中部");
            f.add(but1,BorderLayout.EAST);
            f.add(but2,BorderLayout.WEST);
            f.add(but3,BorderLayout.NORTH);
            f.add(but4,BorderLayout.SOUTH);
            f.add(but5,BorderLayout.CENTER);
            f.setLocation(750,300);
            f.setSize(500,500);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }


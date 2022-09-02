package jisuan;


import javax.swing.*;
import java.awt.*;

public class GridDome {
        public static void main(String[] args) {
            JFrame f=new JFrame("333");
            f.setLayout(new GridLayout
                    (3,3,30,30));
            for(int i=1;i<=9;i++){
                JButton btn=new JButton("btn"+i);
                f.add(btn);
            }
            f.setLocation(700,300);
            f.setSize(450,450);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }


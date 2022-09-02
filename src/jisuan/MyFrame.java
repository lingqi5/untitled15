package jisuan;


import javax.swing.*;
public class MyFrame extends JFrame{
        public MyFrame(){
            this.setTitle("我的窗体！");
            this.setLocation(700,400);
            this.setSize(500,400);
            this.setVisible(true);
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        }

        public static void main(String[] args) {
            new MyFrame();
        }
    }

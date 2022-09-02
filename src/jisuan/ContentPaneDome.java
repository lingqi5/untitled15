package jisuan;


import javax.swing.*;
import java.awt.*;

public class ContentPaneDome extends JFrame {
    public ContentPaneDome(String name){
        Container con=this.getContentPane();
        con.setBackground(Color.RED);
        //this.setLocation(700,400);
        this.setLocationRelativeTo(null);
        this.setSize(500,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(name);
    }

    public static void main(String[] args) {
        new ContentPaneDome("我的窗体！");
    }
}
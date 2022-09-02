package FJgame;

import javax.swing.*;
import java.io.IOException;

public class BaseFrame extends JFrame {
    public MyPanel myPanel;
    public BaseFrame() throws IOException {
        setSize(470, 700);
        setLocation(0, 0);
        setLocationRelativeTo(null);
        setLayout(null);
        this.myPanel=new MyPanel();
        this.myPanel.setBounds(0,0,480,700);
        this.add(this.myPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

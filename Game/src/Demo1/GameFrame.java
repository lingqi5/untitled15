package Demo1;


import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        JFrame frame = new JFrame("俄罗斯方块");
        Tass tas=new Tass();

        frame.setSize(818, 920);

        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        while (true) {
            repaint();
            try {
                Thread.sleep(40);   //40ms,1秒=1000毫秒，大约1秒画25次窗口，就和放电影一样，1秒放25帧
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    //    addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });

    }
}
package FJgame;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyPanel extends JPanel {
    public Image bgImage;
    public int timer=0;
    public int top=0;

    public DrawableTherad drawableTherad;

    //创建一个飞机主角对象
    public Player player;

    public MyPanel() throws IOException {
        this.bgImage=Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\background.png");

        //当窗口创建出来后，主角飞机也被创建
        this.player = new Player(this);

        //创建线程 重绘Panel
        this.drawableTherad=new DrawableTherad(this);

        //启动线程
        this.drawableTherad.start();


    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //绘制背景图
        g.drawImage(this.bgImage, 0, top-this.bgImage.getHeight(this), this.bgImage.getWidth(this),this.bgImage.getHeight(this), null);
        g.drawImage(this.bgImage, 0, top, this.bgImage.getWidth(this),this.bgImage.getHeight(this),null);
        timer++;

        if(timer==10000)
            timer=0;

        if(timer%10==0) {
            top++;

            if(top>this.bgImage.getHeight(this))
                top=0;
        }
        //绘制主角飞机
        this.player.drawSelf(g);
    }
}


package FJgame;

import sun.awt.image.ToolkitImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {
    //使用MyPanel的原因是，要调用MyPanel中的timer
    public MyPanel myPanel;

    //width，height是主角飞机宽度与高度
    public int width = 102;
    public int height = 126;

    //x，y是主角飞机的坐标（左上角）
    public int x;
    public int y;

    //将所有的主角飞机 图片对象放到数组中
    public Image[] images = new Image[] {
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\me1.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\me2.png")
    };

    //存放当前图片的下标
    public int imageIndex = 0;

    public Player(MyPanel myPanel) {
        this.myPanel = myPanel;
        this.x = (480 - this.width)/2;
        this.y = 700 - this.height*2;
    }

    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);

        //每隔50毫秒切换一张图片
        if(this.myPanel.timer%50==0) {
            imageIndex++;
            //图片遍历到最后一个后，图片下标再次重0开始
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }
        }
    }

}

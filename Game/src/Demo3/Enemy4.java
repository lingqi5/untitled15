package Demo3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Enemy4 extends Enemy {

    public Enemy4(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 213;
        this.height = 188;
        this.hp = 10;

        //在界面里
        this.x = (int) (Math.random() * (BaseFrame.frameWidth - this.width));
        this.y = -this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\ComicBoss.png");
    }


    //敌机
    public Image[] images = new Image[]{
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\ComicBoss.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\ComicBoss-2.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\ComicBoss-3.png"),
    };

    //敌机爆炸效果，放在放到数组中
    public Image[] dieImages = new Image[]{
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\enemy4_down1.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\enemy4_down2.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\enemy4_down3.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\enemy4_down4.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\enemy4_down5.png"),
            Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\enemy4_down6.png"),
    };

    //存放当前图片的下标
    public int imageIndex = 0;
    int m = 5;
    //画敌机
    public void drawSelf(Graphics g) {


        //判断敌机是否被击中
        if (hp > 0) {
            g.drawImage(this.image, x, y, width, height, null);
            g.drawImage(this.images[imageIndex], x, y, width, height, null);

            //每隔50毫秒切换一张图片
            if (this.myPanel.timer % 50 == 0) {
                imageIndex++;
                //图片遍历到最后一个后，图片下标再次重0开始
                if (imageIndex == this.images.length) {
                    imageIndex = 0;
                }
            }
        } else {
            //被打中
            g.drawImage(this.dieImages[imageIndex], x, y, width, height, null);

            //每隔10毫秒切换一张图片
            if (this.myPanel.timer % 50 == 0) {
                imageIndex++;
                if (imageIndex >= this.dieImages.length) {
                    //敌机死了
                    killed();
                }
            }
        }

        //敌机向下移动,如果敌机出界就销毁
        /**Random ky = new Random();
         int a = ky.nextInt(20);*/
        if (this.myPanel.timer % 35 == 0) {
            y = y + 10;
          //  x = x - 5;
            if (y >= BaseFrame.frameHeight) {
                killed();
                //         y=y-10;
            }

            if (this.x > (BaseFrame.frameWidth - this.width) || this.x < 0)
                m = -m;
            x += m;
            if (y >= BaseFrame.frameHeight) {
                killed();
            }
        }
    }
}

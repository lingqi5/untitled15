package Demo3;

import java.awt.Image;
import java.awt.Toolkit;

public class Item001 extends Item{
    public Item001(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub
        this.width=30;
        this.height=30;
        this.images=new Image[] {
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star01.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star02.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star03.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star04.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star05.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star06.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star07.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star08.png"),
                Toolkit.getDefaultToolkit().getImage("D:\\zhang\\tupian\\star09.png"),
        };
        this.imageSpeed=(int)(Math.random()*20+5);
        this.speed=3;
    }

}

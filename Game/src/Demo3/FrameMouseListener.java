package Demo3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class FrameMouseListener implements KeyListener {
    public BaseFrame baseFrame;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_UP){
            //this.baseFrame.myPanel.player.x = e.getKeyLocation() - this.baseFrame.myPanel.player.width/2;
            this.baseFrame.myPanel.player.y = this.baseFrame.myPanel.player.y-25;
        }
        if (keyCode==KeyEvent.VK_DOWN){
            this.baseFrame.myPanel.player.y = this.baseFrame.myPanel.player.y+25;
        }
        if (keyCode==KeyEvent.VK_LEFT){
            this.baseFrame.myPanel.player.x= this.baseFrame.myPanel.player.x-25;
        }
        if (keyCode== KeyEvent.VK_RIGHT){
            this.baseFrame.myPanel.player.x= this.baseFrame.myPanel.player.x+25;
        }


    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

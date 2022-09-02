package FJgame;

import Demo1.Cell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JPanel{
    public void moveLeft(){
        JIJIJIJI J=new JIJIJIJI();
                J.left();
        }



    public void start() {
        KeyListener I = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_DOWN:
//                        sortDropAction();
//                        break;
                    case KeyEvent.VK_LEFT:
                        moveLeft();
                        break;
//                    case KeyEvent.VK_RIGHT:
//                        rightMoveAction();
//                        break;
//                    case KeyEvent.VK_UP:
//                        rotateRightAction();
//                        break;
//                    case KeyEvent.VK_SPACE:
//                        handDorpAction();
//                        break;
//
                }
            }
        };
        this.addKeyListener(I);
        this.requestFocus();
    }
            public static void main(String[] args) throws IOException {
                new BaseFrame();

            }
    }
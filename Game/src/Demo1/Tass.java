package Demo1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tass extends JPanel {
    public static BufferedImage backImage;
    public static BufferedImage I;
    public static BufferedImage J;
    public static BufferedImage L;
    public static BufferedImage O;
    public static BufferedImage S;
    public static BufferedImage T;
    public static BufferedImage Z;


    //声明正在下落的方块
    private Tetromino currentOne = Tetromino.randomOne();
    //声明将要下落的方块
    private Tetromino nextOne = Tetromino.randomOne();
    //声明游戏主区域
    private Cell[][] wall = new Cell[18][9];
    int[] scorePoor = {0, 1, 2, 5, 10};
    private int totalScore = 0;
    private int totalLine = 0;
    public final int PLAYING = 0;
    public final int PAUSE = 1;
    public final int GAMEOVER = 2;
    private int game_state;
    String[] show_states = {"P[puase]", "C[continue]", "S[replay]"};


    //声明单元格的像素为48
    private final int Cell_Size = 48;

    static {
        try {
            backImage = ImageIO.read(new File("D:\\zhang\\backgroud.png"));
            I = ImageIO.read(new File("D:\\zhang\\I.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            J = ImageIO.read(new File("D:\\zhang\\J.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            L = ImageIO.read(new File("D:\\zhang\\L.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            O = ImageIO.read(new File("D:\\zhang\\O.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            S = ImageIO.read(new File("D:\\zhang\\S.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            T = ImageIO.read(new File("D:\\zhang\\T.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Z = ImageIO.read(new File("D:\\zhang\\Z.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(backImage, 0, 0, null);
        g.drawImage(I, 0, 0, null);
        g.drawImage(J, 0, 0, null);
        g.drawImage(L, 0, 0, null);
        g.drawImage(O, 0, 0, null);
        g.drawImage(S, 0, 0, null);
        g.drawImage(T, 0, 0, null);
        g.drawImage(Z, 0, 0, null);
        //平移坐标轴
        g.translate(44, 40);
        //绘制游戏主区域
        paintwall(g);
        //绘制正在下落的四方格
        paintCurrentOne(g);
        paintScore(g);
       // paintNextOne(g);
        paintStates(g);


    }

    public void paintNextOne(Graphics g) {
        Cell[] cells = currentOne.cell;
        for (Cell cell : cells) {
            int x = cell.getCol() * Cell_Size + 350;
            int y = cell.getRow() * Cell_Size + 20;
            g.drawImage(cell.getImage(), x, y, null);
        }
    }

    public void paintStates(Graphics g) {
        if (game_state == PLAYING) {
            g.drawString(show_states[0], 500, 660);
        } else if (game_state == PAUSE) {
            g.drawString(show_states[1], 500, 660);
        } else if (game_state == GAMEOVER) {
            g.drawString(show_states[2], 500, 660);
            g.setColor(Color.red);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
            g.drawString("GAMEOVER!", 30, 400);
        }
    }


    public boolean isGameOver() {
        Cell[] cell = nextOne.cell;
        for (Cell cell1 : cell) {
            int row = cell1.getRow();
            int col = cell1.getCol();
            if (wall[row][col] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullLine(int row) {
        Cell[] cells = wall[row];
        for (Cell cell : cells) {
            if (cell == null) {
                return false;
            }
        }
        return true;
    }

    public void destoryLine() {
        int Line = 0;
        Cell[] cells = currentOne.cell;
        for (Cell cell : cells) {
            int row = cell.getRow();
            if (isFullLine(row)) {
                Line++;
                for (int i = row; i > 0; i--) {
                  //  wall[0]=new Cell[0];
                  System.arraycopy(wall[i-1],0,wall[i],0,9);
                }
               wall[0]=new Cell[9];
            }
        }
        totalScore += scorePoor[Line];
        totalLine += Line;
    }

    public boolean canDorp() {
        Cell[] cell = currentOne.cell;
        for (Cell cell1 : cell) {
            int row = cell1.getRow();
            int col = cell1.getCol();
            if (row == 17) {
                return false;
            } else if (wall[row + 1][col] != null) {
                return false;
            }
        }
        return true;
    }

    //按键一次四方格下落一格
    public void sortDropAction() {
        //判断能否下落
        if (canDorp()) {
            //当前四方格下落
            currentOne.softDrop();
        } else {
            //将四方格嵌入到墙中
             landwall();
             destoryLine();


            //判断能否消行

            //游戏是否结束
            if (isGameOver()) {
                game_state = GAMEOVER;
            } else {
                currentOne = nextOne;

               nextOne = Tetromino.randomOne();
            }
        }
    }

    private void landwall() {
        Cell[] cells = currentOne.cell;
        for (Cell cell : cells) {
            int row = cell.getRow();
            int col = cell.getCol();
            wall[row][col] = cell;
        }
    }

    //瞬间下落
    public void handDorpAction() {
        //判断四方格能否下落
        while (true) {
            if (canDorp()) {
                currentOne.softDrop();
            } else {

                landwall();

                destoryLine();
                currentOne = nextOne;
                nextOne = Tetromino.randomOne();
                //判断游戏是否结束
                if (isGameOver()) {
                    game_state = GAMEOVER;

                } else {
                    currentOne = nextOne;
                    nextOne = Tetromino.randomOne();
                }
            }
        }
    }

    //创建顺时针旋转
    public void rotateRightAction() {
        currentOne.rotateRight();
        if (outOfBouds() || coincide()) {
            currentOne.rotateLeft();
        }
    }

    private void paintCurrentOne(Graphics g) {
        Cell[] cells = currentOne.cell;
        for (Cell cell : cells) {
            int x = cell.getCol() * Cell_Size;
            int y = cell.getRow() * Cell_Size;
            g.drawImage(cell.getImage(), x, y, null);
        }
    }

    private void paintwall(Graphics g) {
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length; j++) {
                int x = j * Cell_Size;
                int y = i * Cell_Size;
                Cell cell = wall[i][j];
                if (cell == null) {
                    g.drawRect(x, y, Cell_Size, Cell_Size);
                } else {
                    g.drawImage(cell.getImage(), x, y, null);
                }
            }
        }
    }

    public boolean outOfBouds() {
        Cell[] cell = currentOne.cell;
        for (Cell cell1 : cell) {
            int col = cell1.getCol();
            int row = cell1.getRow();
            if (col < 0 || col > wall[0].length - 1 || row < 0 || row > wall.length - 1) {
                return true;
            }
        }
        return false;
    }

    public void paintScore(Graphics g) {
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.drawString("SCORES" + totalScore, 500, 240);
        g.drawString("LINES" + totalLine, 500, 400);

    }

    //判断方块是否重合
    public boolean coincide() {
        Cell[] cell = currentOne.cell;
        for (Cell cell1 : cell) {
            int col = cell1.getCol();
            int row = cell1.getRow();
            if (wall[row][col] != null) {
                return true;
            }

        }
        return false;
    }

    public void leftMoveAction() {
        currentOne.moveLeft();
        //判断是否越界 是否有四方格
        if (outOfBouds() || coincide()) {
            currentOne.moveRight();
        }

    }

    public void rightMoveAction() {
        currentOne.moveRight();
        //判断是否越界 是否有四方格
        if (outOfBouds() || coincide()) {
            currentOne.moveLeft();
        }

    }

    public void start() {
        game_state = PLAYING;
        KeyListener I = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_DOWN:
                        sortDropAction();
                        break;
                    case KeyEvent.VK_LEFT:
                        leftMoveAction();
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightMoveAction();
                        break;
                    case KeyEvent.VK_UP:
                        rotateRightAction();
                        break;
                    case KeyEvent.VK_SPACE:
                        handDorpAction();
                        break;
                    case KeyEvent.VK_P:
                        if (game_state == PLAYING) {
                            game_state = PAUSE;
                        }
                        break;
                    case KeyEvent.VK_C:
                        if (game_state == PAUSE) {
                            game_state = PLAYING;
                        }
                        break;
                    case KeyEvent.VK_S:
                        game_state = PLAYING;
                        wall = new Cell[18][9];
                        currentOne = Tetromino.randomOne();

                        nextOne = Tetromino.randomOne();
                        totalLine = 0;
                        totalScore = 0;

                        break;
                }

            }
        };
        this.addKeyListener(I);
        this.requestFocus();

        //判断当前游戏状态在游戏中时每隔0.5s下落一次
        while (true) {
            if (game_state == PLAYING) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (canDorp()) {
                    currentOne.softDrop();
                } else {
                    landwall();
                //    destoryLine();

                    // 游戏是否结束
                    if (isGameOver()) {
                        game_state = GAMEOVER;
                    } else {
                        currentOne = nextOne;
                        nextOne = Tetromino.randomOne();
                    }
                }
            }
            repaint();
        }

    }

    public static void main(String[] args) {


        JFrame jFrame = new JFrame("俄罗斯方块");
        Tass tass = new Tass();
        jFrame.add(tass);
        jFrame.setVisible(true);
        jFrame.setSize(820, 960);
        jFrame.setLocation(0, 0);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tass.start();


    }

}


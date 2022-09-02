package Demo1;

import java.util.concurrent.Callable;

/*
Cell数组用于创建小方块
方法:左移一格 右移一格 下落一格 变形
 */
public class Tetromino {
    protected Cell[] cell=new Cell[4];
    //编写旋转状态
    protected State[]states;

    //编写顺时针旋转四方格方法
    public void rotateRight(){
        if (states.length==0){
            return;
        }
        count++;
        State s=states[count%states.length];
        Cell cells=cell[0];
        int row= cells.getRow();
        int cow= cells.getCol();

        cell[1].setRow(row+s.row1);
        cell[1].setCol(cow+s.cow1);
        cell[2].setRow(row+s.row2);
        cell[2].setCol(cow+s.cow2);
        cell[3].setRow(row+s.row3);
        cell[3].setCol(cow+s.cow3);

    }
    public void rotateLeft(){
        if (states.length==0){
            return;
        }
        count--;
        State s=states[count%states.length];
        Cell cells=cell[0];
        int row= cells.getRow();
        int cow= cells.getCol();

        cell[1].setRow(row+s.row1);
        cell[1].setCol(cow+s.cow1);
        cell[2].setRow(row+s.row2);
        cell[2].setCol(cow+s.cow2);
        cell[3].setRow(row+s.row3);
        cell[3].setCol(cow+s.cow3);

    }
    //声明旋转次数
    protected int count=10000;

    //编写四方格旋转状态内部类
    class State{
        //编写属性：四方格位置
        int row0,cow0,row1, cow1,row2,cow2,row3,cow3;

        public State(int row0,int cow0,int row1,int cow1,int row2,int cow2,int row3,int cow3) {
            this.row0 = row0;
            this.cow0=cow0;
            this.row1=row1;
            this.cow1=cow1;
            this.row2=row2;
            this.cow2=cow2;
            this.row3=row3;
            this.cow3=cow3;
        }

        public int getRow0() {
            return row0;
        }

        public void setRow0(int row0) {
            this.row0 = row0;
        }

        public int getCow0() {
            return cow0;
        }

        public void setCow0(int cow0) {
            this.cow0 = cow0;
        }

        public int getRow1() {
            return row1;
        }

        public void setRow1(int row1) {
            this.row1 = row1;
        }

        public int getCow1() {
            return cow1;
        }

        public void setCow1(int cow1) {
            this.cow1 = cow1;
        }

        public int getCow3() {
            return cow3;
        }

        public void setCow3(int cow3) {
            this.cow3 = cow3;
        }

        public int getRow3() {
            return row3;
        }

        public void setRow3(int row3) {
            this.row3 = row3;
        }

        public int getCow2() {
            return cow2;
        }

        public void setCow2(int cow2) {
            this.cow2 = cow2;
        }

        public int getRow2() {
            return row2;
        }

        public void setRow2(int row2) {
            this.row2 = row2;
        }

        @Override
        public String toString() {
            return "State{" +
                    "row0=" + row0 +
                    ", cow0=" + cow0 +
                    ", row1=" + row1 +
                    ", cow1=" + cow1 +
                    ", row2=" + row2 +
                    ", cow2=" + cow2 +
                    ", row3=" + row3 +
                    ", cow3=" + cow3 +
                    '}';
        }
    }
    //编写左移方法
    public void moveLeft(){
        for (Cell cell:cell){
            cell.left();
        }
    }
    //编写右移方法
    public void moveRight(){
        for (Cell cell:cell){
            cell.right();
        }
    }
    //编写下落方法
    public void softDrop(){
        for (Cell cell:cell){
            cell.drop();
        }
    }
    //编写随机生成四方格的静态方法
    public static Tetromino randomOne(){
        int num = (int) (Math.random() * 7);
        Tetromino tetromino=null;
        switch (num){
            case 0:
                tetromino=new I();
                break;
            case 1:
                tetromino=new J();
                break;
            case 2:
                tetromino=new L();
                break;
            case 3:
                tetromino=new O();
                break;
            case 4:
                tetromino=new S();
                break;
            case 5:
                tetromino=new T();
                break;
            case 6:
                tetromino=new Z();
                break;
        }
      return tetromino;
    }
}

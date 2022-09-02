package Demo1;


public class I extends Tetromino{
    public I() {
        cell[0]=new Cell(0,4,Tass.I);
        cell[1]=new Cell(0,3,Tass.I);
        cell[2]=new Cell(0,5,Tass.I);
        cell[3]=new Cell(0,6,Tass.I);
        //共计2种旋转状态
        states=new State[2];
        //初始化2种状态的相对坐标
        states[0]=new State(0,0,0,-1,0,1,0,2);
        states[1]=new State(0,0,-1,0,1,0,2,0);

    }
}

package Demo1;

public class L extends Tetromino{
    public L() {
        cell[0]=new Cell(0,4,Tass.L);
        cell[1]=new Cell(0,3,Tass.L);
        cell[2]=new Cell(0,5,Tass.L);
        cell[3]=new Cell(1,3,Tass.L);
        states=new State[4];
        states [0]=new State(0,0,0,-1,0,1,1,-1);
        states [1]=new State(0,0,-1,0,1,0,-1,-1);
        states [2]=new State(0,0,0,1,0,-1,-1,1);
        states [3]=new State(0,0,1,0,-1,0,1,1);
    }
}



package Demo1;

public class T extends Tetromino{
    public T() {
        cell[0]=new Cell(0,4,Tass.T);
        cell[1]=new Cell(0,3,Tass.T);
        cell[2]=new Cell(0,5,Tass.T);
        cell[3]=new Cell(1,4,Tass.T);
        states=new State[4];
        states[0]=new State(0,0,0,-1,0,1,1,0);
        states[1]=new State(0,0,-1,0,1,0,0,-1);
        states[2]=new State(0,0,0,1,0,-1,-1,0);
        states[3]=new State(0,0,1,0,-1,0,0,1);
    }
}

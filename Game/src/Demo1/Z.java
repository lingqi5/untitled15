package Demo1;

public class Z extends Tetromino{
    public Z() {
        cell[0]=new Cell(1,4,Tass.Z);
        cell[1]=new Cell(0,3,Tass.Z);
        cell[2]=new Cell(0,4,Tass.Z);
        cell[3]=new Cell(1,5,Tass.Z);
        states=new State[2];
        states[0]=new State(0,0,-1,-1,-1,0,0,1);
        states[1]=new State(0,0,-1,1,0,1,1,0);
    }
}

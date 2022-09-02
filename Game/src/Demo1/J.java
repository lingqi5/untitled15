package Demo1;

public class J extends Tetromino{
    public J() {
        cell[0]=new Cell(0,4,Tass.J);
        cell[1]=new Cell(0,3,Tass.J);
        cell[2]=new Cell(0,5,Tass.J);
        cell[3]=new Cell(1,5,Tass.J);
        states =new State[4];
        states[0]=new State(0,0,0,-1,0,1,1,1);
        states[1]=new State(0,0,-1,0,1,0,1,-1);
        states[2]=new State(0,0,0,1,0,-1,-1,-1);
        states[3]=new State(0,0,1,0,-1,0,-1,1);

    }
}

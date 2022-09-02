package Demo1;

public class O extends Tetromino{
    public O() {
        cell[0]=new Cell(0,4,Tass.O);
        cell[1]=new Cell(0,5,Tass.O);
        cell[2]=new Cell(1,4,Tass.O);
        cell[3]=new Cell(1,5,Tass.O);
        states=new State[0];
    }
}

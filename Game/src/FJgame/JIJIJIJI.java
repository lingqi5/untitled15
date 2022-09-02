package FJgame;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class JIJIJIJI {
    private int col;
    private int row;
    private Image image;
   public JIJIJIJI(int col,int row,Image image)  {
       this.col=col;
       this.row=row;
       this.image=image;
   }

    public JIJIJIJI() {

    }

    public Image getImage() {
        return image;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JIJIJIJI cell = (JIJIJIJI) o;
        return row == cell.row &&
                col == cell.col &&
                Objects.equals(image, cell.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, image);
    }
    public void left(){
        col--;
    }
    public void right(){
        col++;
    }
    public void drop(){
        row++;
    }
}


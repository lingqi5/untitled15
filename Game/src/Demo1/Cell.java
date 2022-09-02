package Demo1;

import com.sun.corba.se.spi.logging.CORBALogDomains;
import javafx.beans.property.ReadOnlyBooleanWrapper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

/*
编写小方块类
属性:行 列 小方格
方法:左移一格 右移一格 下落一格

 */
public class Cell {
    private int row;
    private int col;
    private BufferedImage image;

    public Cell(int row, int col, BufferedImage image) {
        this.row = row;
        this.col =col;
        this.image=image;
    }


    public BufferedImage getImage() {
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
        Cell cell = (Cell) o;
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
    public void rise(){
        row--;
    }
}

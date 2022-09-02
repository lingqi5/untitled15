package Wj;

public class MulOperator extends Operator{
    public MulOperator(int left,int right){
        setLeft(left);
        setRight(right);
    }
    @Override
    public int cal(){
        return getRight()*getLeft();
    }
}

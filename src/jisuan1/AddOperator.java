package Wj;

public class AddOperator extends Operator{
    public AddOperator(int left,int right){
        setLeft(left);
        setRight(right);
    }
    @Override
    public int cal(){
        return getRight()+getLeft();
    }
}

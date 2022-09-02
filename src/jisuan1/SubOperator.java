package Wj;

public class SubOperator extends Operator{
    public SubOperator(int left,int right){
        setLeft(left);
        setRight(right);
    }
    @Override
    public int cal(){
        return getLeft()-getRight();
    }
}

package Wj;

public class DivOperator extends Operator{
    public DivOperator(int left,int right){
        setLeft(left);
        setRight(right);
    }
    @Override
    public int cal() {
        if (getRight() == 0) {
           System.out.println("被除数不能为0！");
            return 0;
        }
        return getLeft()/getRight();
    }
}

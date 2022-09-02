package Wj;

public class OperatorFactory {
    public static Operator create(String op,String sleft,String sright){
        Operator operator=null;
        int left=Integer.parseInt(sleft);
        int right=Integer.parseInt(sright);
        switch (op){
            case "+":
                operator=new AddOperator(left,right);
                break;
            case "-":
                operator=new SubOperator(left,right);
                break;
            case "*":
                operator=new MulOperator(left,right);
                break;
            case "/":
                operator=new DivOperator(left,right);
                break;
            default:
                System.out.println("输入有误");
                break;

        }
        return operator;
    }
}

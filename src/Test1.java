public class Test1 {
    public static void main(String[] args) {
        B b = new B(10, 'A');
        b.show();
        b.methodC(1);
    }
}
class B{
    private int x;
    private char y;

    public B(int i,char j){
        x=i;
        y=j;
    }
    public void show(){
        System.out.println("x="+x+";y="+y);
    }
    public void methodC(int x){
        this.x=this.x+x;
        y++;
        show();
    }
}

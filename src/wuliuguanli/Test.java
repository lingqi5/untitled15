package wuliuguanli;

import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_DISTANTPeer;
import wuliuguanli.ZTransportation;

public class Test {
    public static void main(String[] args) {
        SendTask task = new SendTask("HYX600235",76.34);
        //调用送前准备方法
        task.sendBefore();
        System.out.println("=================================");
        //创建交通工具
        ZTransportation t = new ZTransportation("小韩","Z025","大奔");
        //创建GPS对象
        Phone p = new Phone();
        //将交通工具与GPS工具传入送货方法
        task.send(t, p);
        System.out.println("=================================");
        //调用送后操作方法
        task.sendAfter(t);
        t.upKeep();
    }
}

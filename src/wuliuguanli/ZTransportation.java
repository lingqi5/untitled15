package wuliuguanli;

   public  class ZTransportation extends Transportation implements Careable{
        public ZTransportation() {
            super();//在继承关系中访问父类的成员变量，在构造方法中访问父类的构造方法
        }
        public ZTransportation(String carrier, String carnumber, String carmodel) {
            super(carrier,carnumber,carmodel);
        }

       @Override
       public void transportation() {

       }

       @Override
        public void transport() {
            System.out.println("运输中");
        }

        public void upKeep() {
            System.out.println("货物运输车辆保养完毕");
        }
    }



//package jisuan1;
//
//import Wj.OperatorFactory;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//@SuppressWarnings("serial")
//public class CalcFrame extends JFrame {
//    private String left="";
//    private String right="";
//    private String op="";
//    private boolean leftlnput=true;
//    private JTextField txResult;
//
//
//    //构造方法
//    public CalcFrame(){
//        initialzeComponents();
//    }
//    private class NumberHandler implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//            JButton btn=(JButton)e.getSource();
//            if (leftlnput){
//                left+=btn.getText();
//                txResult.setText(left);
//            }else {
//                right+=btn.getText();
//                txResult.setText(right);
//            }
//        }
//    }
//    private class OperatorHandler implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//            JButton bth=(JButton)e.getSource();
//            op=bth.getText();
//            leftlnput=false;
//        }
//    }
//    private class EqualHandler implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//            if (op.isEmpty()||left.isEmpty())return;;
//            if (right.isEmpty())
//                right=left;
//            Wj.Operator opr= OperatorFactory.create(op,left,right);
//            txResult.setText(opr.cal()+"");
//            left=txResult.getText();
//            leftlnput=true;
//
//        }
//    }
//    private class ClearHandler implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//            left=right=op="";
//            leftlnput=true;
//            txResult.setText("0");
//        }
//    }
//    private boolean isOperator(String s){
//        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
//    }
//    private void initialzeComponents(){
//        String[] texts={"<-","CE","C","-",
//        "7","8","9","*",
//        "4","5","6","/",
//        "1","2","3","",
//        "0",".","+",""};
//        txResult=new JTextField("0");
//        txResult.setBounds(12,12,278,36);
//        txResult.setHorizontalAlignment(JTextField.RIGHT);
//        txResult.setFocusable(false);
//        int x=12;
//        int y=60;
//        for (int i=0;i< texts.length;i++){
//            if (texts[i].isEmpty())continue;
//            JButton bth=new JButton(texts[i]);
//            bth.setBounds(x+(i%4)*72,y+(i/4)*60,60,48);
//            bth.setFocusable(false);
//            if (Character.isDigit(texts[i].charAt(0)))
//                bth.addActionListener(new NumberHandler());
//            else if (isOperator(texts[i]))
//                bth.addActionListener(new ClearHandler());
//            this.add(bth);
//        }
//        JButton bthEqual=new JButton("=");
//        bthEqual.setBounds(228,240,60,108);
//        bthEqual.addActionListener(new EqualHandler());
//        this.add(bthEqual);
//        this.setJMenuBar(createMenubar());
//        this.setLayout(null);
//        this.add(txResult);
//        this.setTitle("计算机");
//        this.setSize(312,430);
//        this.setLocationRelativeTo(null);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//    private JMenuBar createMenubar(){
//        JMenuBar bar=new JMenuBar();
//        JMenu mnView=new JMenu("查看(V)");
//        mnView.setMnemonic('V');
//        JMenu mnEdit=new JMenu("编辑(E)");
//        mnEdit.setMnemonic('E');
//        JMenu mnHelp=new JMenu("帮助(H)");
//        mnEdit.setMnemonic('H');
//        bar.add(mnView);
//        bar.add(mnEdit);
//        bar.add(mnHelp);
//        return bar;
//    }
//
//    public static void main(String[] args) {
//        new CalcFrame().setVisible(true);
//    }
//
//}

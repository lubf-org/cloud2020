package cn.les.juc;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2021/2/6 15:48
 */
public class TestThred {
    public static void main(String[] args) {
        for (int i =0 ; i<10;i++){
            new MyThread().start();
        }
    }
}

class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"----");
    }

}
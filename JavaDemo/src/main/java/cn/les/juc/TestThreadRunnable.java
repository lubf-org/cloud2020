package cn.les.juc;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2021/2/6 15:16
 */
public class TestThreadRunnable {
    public static void main(String[] args) {
        ThreadRunnable th = new ThreadRunnable();
        //for(int i = 0; i<10;i++){
            new Thread(th).start(); //每次新开一个线程，加入任务，开启
        //}
        new Thread(th).start();
        new Thread(th).start();
        for(int i = 0; i<10;i++){
            System.out.println("---------------------"+i);
        }
    }
}


class ThreadRunnable implements Runnable{

    @Override
    public synchronized void run() {
        for(int i = 0; i<100;i++){
            if( i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
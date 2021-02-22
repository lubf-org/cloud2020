package cn.les.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author
 * @version v1.0.0
 * @descripton
 * @2021/2/6 15:42
 */
public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(); //newFixedThreadPool(5); // //
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        //newFixedThreadPool固定线程数的线程池和newCachedThreadPool用法一样
        /* for(int i = 0; i<10;i++){
            executorService.submit(new ThreadPool()); //适合runnable接口\ callable接口
            //executorService.execute(适合runnable接口);//适合适合runnable接口
        }*/

        //调度线程池
        Future<String> future1 =  scheduledExecutorService.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }
                return sum +"";
            }

        }, 3, TimeUnit.SECONDS);



        //
        /*List<Future<String>> futures = new ArrayList<>();
        for(int i = 0; i<10000;i++){
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int sum = 0;
                    for (int i = 1; i <= 1000; i++) {
                        sum += i;
                    }
                    System.out.println(Thread.currentThread().getName()+"---"+sum);
                    return sum +"";
                }

            });
            futures.add(future);
        }*/




       /*for(Future<String> futures1:futures ){
           System.out.println(futures1.get());
       }*/

        System.out.println(future1.get());
        executorService.shutdown(); //平和的方式关闭，等待线程池中完成再关闭
        scheduledExecutorService.shutdown();
    }
}

class ThreadPool implements Runnable{

    @Override
    public synchronized void run() {
        for(int i = 0; i<100;i++){
            if( i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
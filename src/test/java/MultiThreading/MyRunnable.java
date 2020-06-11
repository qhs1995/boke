package MultiThreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/11/7 12:29
 * @Desc: 自定义线程实现
 */
public class MyRunnable implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(MyRunnable.class);

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    private static Lock lock = new ReentrantLock();

    private volatile  static int num=10;

    @Override
    public void run() {
        while (num>0){
//            lock.lock();
//                if (num>0){
//                    try {
//                        Thread.sleep(2000);
//                        sale();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            lock.unlock();

          //代码块实现
            synchronized (MyRunnable.class){
                if (num>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sale();
                }

            }

        }


    }

    public  void sale(){

        if (num>0){
            System.out.println(this.name+"正在出售第"+num+"张票");
            num--;
        }


    }

}

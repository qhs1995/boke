package MultiThreading;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/11/7 12:28
 * @Desc: 多线程拒绝策略
 */
public class RejectedPolicy extends TestCase {
    private static final Logger logger = LoggerFactory.getLogger(RejectedPolicy.class);

    private static  final int CAPACITY = 1;

    @Test
    public void test1(){

        //corePoolSize+ArrayBlockingQueue指定的容量<=maximumPoolSize  否则将会跑出异常或者导致某些线程不执行（根据下面的拒绝策略）
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(100, 200, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
        //        设置拒绝策略
        //        ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
        //        ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
        //        ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        //        ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i=0;i<10000;i++){
            MyRunnable runnable = new MyRunnable("MyRunnable"+i);
            pool.execute(runnable);
            System.out.println("线程池中线程数目：" +pool.getPoolSize() + "，队列中等待执行的任务数目："+pool.getQueue().size() + "，已执行完的任务数目："+pool.getCompletedTaskCount());
        }
        //关闭线程池
        pool.shutdown();
    }

    @Test
    public void test2(){

        SynchronousQueue executorQueue = new SynchronousQueue();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, executorQueue);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i=0;i<10;i++){
            MyRunnable runnable = new MyRunnable("MyRunnable" + i);
            pool.execute(runnable);
        }
        //关闭线程池
        pool.shutdown();
    }


}

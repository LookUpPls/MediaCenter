package ljj.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

@Component("pool")
public class ThreadPool {
    public static ThreadPoolExecutor pool = new ThreadPoolExecutor(300,600,5, TimeUnit.MINUTES,new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());
}

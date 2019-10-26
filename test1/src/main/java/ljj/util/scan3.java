package ljj.util;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class scan3 {
    private final Lock watchLock = new ReentrantLock();
    Stack<File> stk = new Stack<File>();

    @Resource(name = "pool")
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(30, 6000, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());
    private ArrayList<File> imgDirs = new ArrayList<File>();
    private long allTasks = 0;
    private long complatedTasks = 0;
    private ReentrantReadWriteLock lockAll = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock lockComplate = new ReentrantReadWriteLock();


    public static void main(String[] args) {
        scan utilScan = new scan();
        System.out.println(Arrays.toString(utilScan.scanLocalDir().toArray()));

    }

    public List<File> scanLocalDir() {
        File[] roots = File.listRoots();
        try {
            lockAll.writeLock().lock();
            stk.addAll(Arrays.asList(roots));
            allTasks += roots.length;
        } finally {
            lockAll.writeLock().unlock();
        }
        long timestart = System.currentTimeMillis();

        pool.submit(new FindDirRunable());
        pool.submit(new FindDirRunable());

        while (complatedTasks < 7000) {
            //死循环监视是否结束，目前还有问题
            System.out.print("allTasks = " + allTasks);
            System.out.print("  complatedTasks = " + complatedTasks);
            System.out.print("  getQueue() = " + pool.getQueue().size());
            System.out.print("  getActiveCount() = " + pool.getActiveCount());
            System.out.println("  getCompletedTaskCount() = " + pool.getCompletedTaskCount());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreadPool.pool.shutdownNow();
        System.out.println("end");
        System.out.println(System.currentTimeMillis() - timestart);
        System.out.print("allTasks = " + allTasks);
        System.out.print("  complatedTasks = " + complatedTasks);
        System.out.print("  getQueue() = " + pool.getQueue().size());
        System.out.print("  getActiveCount() = " + pool.getActiveCount());
        System.out.println("  getCompletedTaskCount() = " + pool.getCompletedTaskCount());
        return imgDirs;
    }

    private class FindDirRunable implements Runnable {

        @Override
        public void run() {
            File dir;
            while (!stk.empty()) {//当栈不为空，就一直循环压栈出栈过程。
                try {
                    dir = stk.pop();//弹出栈顶元素            try {
                    File[] dirs = dir.listFiles();
                    boolean isImgDir = false;
                    if (dirs != null) {
                        for (File each : dirs) {//遍历文件夹下的东西
                            if (each.isFile()) {
                                if (!isImgDir) {//判断文件夹里有没有图片
                                    String[] temp = each.getName().split("\\.");
//                                System.out.println(Arrays.toString(temp));
                                    String type = temp[temp.length - 1];
                                    if (Dict.imgTypes.contains(type.toLowerCase())) {
                                        isImgDir = true;
                                        imgDirs.add(dir);
                                    }
                                }
                            } else if (each.isDirectory()) {//递归遍历文件夹
                                stk.push(each);
                            }
                        }
                    }

                } finally {
                    //同步加 完成的任务数
                    try {
                        lockComplate.writeLock().lock();
                        complatedTasks++;
                    } finally {
                        lockComplate.writeLock().unlock();
                    }
//                watchLock.notify();//每完成一个任务就唤醒主循环判断是不是所有任务都执行完了
                }
            }
        }
    }

    ;
}

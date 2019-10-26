package ljj.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class scan2 {
    public static void main(String[] args) throws IOException {
        ArrayList<File> imgDirs = new ArrayList<File>();

        // 使用栈，进行深度遍历
        Stack<File> stk = new Stack<File>();
        File[] roots = File.listRoots();
        stk.addAll(Arrays.asList(roots));//父文件压栈
        long errCount = 0;

        File dir;
        while (!stk.empty()) {//当栈不为空，就一直循环压栈出栈过程。
            dir = stk.pop();//弹出栈顶元素

            try {
                File[] dirs = dir.listFiles();
                boolean isImgDir = false;
                if (dirs != null) {
                    for (File each : dirs) {//遍历文件夹下的东西
                        if (each.isDirectory()) //递归遍历文件夹
                            stk.push(each);
//                        else if (each.isFile()) {
//                            if (!isImgDir) {//判断文件夹里有没有图片
//                                String[] temp = each.getName().split("\\.");
////                                System.out.println(Arrays.toString(temp));
//                                String type = temp[temp.length - 1];
//                                if (Dict.imgTypes.contains(type.toLowerCase())) {
//                                    isImgDir = true;
//                                    imgDirs.add(dir);
//                                }
//                            }
//                        }
                    }
                }

            } finally {
                errCount++;
                System.out.println("complated:" + errCount + "  stack.size()" + stk.size());
                //同步加 完成的任务数
//                watchLock.notify();//每完成一个任务就唤醒主循环判断是不是所有任务都执行完了
            }
        }

        System.out.println("end");
        System.out.println(Arrays.toString(imgDirs.toArray()));
    }
}

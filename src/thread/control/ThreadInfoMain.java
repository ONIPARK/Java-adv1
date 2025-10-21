package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainTread = Thread.currentThread();
        log("mainThread = " + mainTread);
        log( "mainTread.getName()" + mainTread.getName());
        log("mainTread.getName()" + mainTread.getName());
        log("mainTread.getPriority()" + mainTread.getPriority()); // 1~10 (基本値: 5)
        log("mainTread.getThreadGroup()" + mainTread.getThreadGroup());
        log("mainTread.getState()" + mainTread.getState());


        // myThread スレッド
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId()" + myThread.threadId());
        log("myThread.getName()" + myThread.getName());
        log("myThread.getPriority()" + myThread.getPriority()); // 1~10 (基本値: 5)
        log("myThread.getThreadGroup()" + myThread.getThreadGroup());
        log("myThread.getState()" + myThread.getState());
    }
}

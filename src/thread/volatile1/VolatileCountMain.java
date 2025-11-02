package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag を false に設定することを試み");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 終了");
    }

    static class MyTask implements Runnable {
        //boolean runFlag = true;
        //long count;
        volatile boolean runFlag = true;
        volatile long count;

        @Override
        public void run() {
            while (runFlag) {
                count++;
                // 1億番に1回ごとに出力
                if (count % 100_000_000 == 0) {
                    // コメント処理すると...
                    log("flat = " + runFlag + ", count = " + count + "in while()");
                }
                log("flat = " + runFlag + ", count = " + count + "終了");
            }
        }
    }
}

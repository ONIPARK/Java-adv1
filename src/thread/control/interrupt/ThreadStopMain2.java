package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMain2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("作業中断を指示 thread.interrupt()");
        thread.interrupt();
        log("work スレッド interrupt 状態 1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("作業中");
                    Thread.sleep(3000); // スレッドが待機状態になるコードに出くわすと InterruptedException が発生する
                }
            } catch (InterruptedException e) {
                log("work スレッド Interrupt 状態 2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("資源整備");
            log("作業終了");
        }
    }
}

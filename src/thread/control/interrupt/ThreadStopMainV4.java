package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100); // 処理時間の短縮
        log("作業中断を指示 thread.interrupt()");
        thread.interrupt();
        log("work スレッド割り込み状態1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            // 割り込み状態変更 O: Interrupt 状態を確認後、ture を返し、代わりに現在の　thread の interrupt 状態を false に変更
            while (!Thread.interrupted()) {
                log("作業中");
            }
            log("work スレッド割り込み状態2 = " + Thread.currentThread().isInterrupted());

            try {
                log("リソース解放を試み");
                Thread.sleep(1000);
                log("リソース整理完了");
            } catch (InterruptedException e) {
                log("リソース整理失敗 - リソース生理中、割り込み発生");
                log("work スレッド割り込み状態3 = " + Thread.currentThread().isInterrupted());
            }
            log("作業終了");
        }
    }
}

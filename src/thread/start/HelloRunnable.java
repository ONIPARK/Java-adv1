package thread.start;

public class HelloRunnable implements Runnable {

    @Override
    public void run() { // 実行する作業のみ
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
 }

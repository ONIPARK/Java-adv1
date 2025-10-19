package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWork(1000, "A"), "Thread-A");
        Thread threadB = new Thread(new PrintWork(500, "B"), "Thread-B");

        threadA.start();
        threadB.start();

    }
    static class PrintWork implements Runnable {
        private int time;
        private String name;

        public PrintWork(int time, String name) {
            this.time = time;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) { // 無限ループ
                log(name);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

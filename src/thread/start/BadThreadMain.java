package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": run() 呼び出し前");

        helloThread.run(); // run() 直接実行
        System.out.println(Thread.currentThread().getName() + ": run() 呼び出し後");

        System.out.println(Thread.currentThread().getName() + "main() end");
    }
}

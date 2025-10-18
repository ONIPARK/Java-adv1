package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        // main Thread 呼び出し
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 呼び出し前");

        helloThread.start(); // Main Thread は待機しない
        System.out.println(Thread.currentThread().getName() + ": start() 呼び出し後");

        System.out.println(Thread.currentThread().getName() + "main() end");
    }
}

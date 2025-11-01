package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

class MyPrinterV4 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("プリンターする文書を入力してください。(終了：q): ");
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    Thread.yield(); // 追加
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log("出力開始：" + job + " 待機文書：" + jobQueue);
                    Thread.sleep(3000); // 出力にかかる時間
                    log("出力完了");
                } catch (InterruptedException e) {
                    log("インタラプト！");
                    break;
                }
            }
            log("プリンター終了");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}

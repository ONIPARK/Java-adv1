package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV2 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            log("プリンターする文書を入力してください。終了（q）: ");
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printer.work = false;
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) { // ① ジョブキューが空きであれば、while文に戻る
                    continue;
                }
                try {
                    String job = jobQueue.poll(); // ② ジョブキューに作業がある場合、作業を取り出す
                    log("出力開始: " + job + ", 待機文書: " + jobQueue);
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    log("インタラプト！");
                    log("プリンター終了");
                }
            }
        }

        public void addJob(String input) {
            jobQueue.offer(input); // プリンター作業を追加する ⇨ 自分のジョブキューに作業を入れておく
        }

    }
}

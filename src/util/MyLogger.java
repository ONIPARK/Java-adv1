package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 直接に生成できないように抽象クラスで生成する
public abstract class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {
        String time = LocalTime.now().format(formatter);
        // 常に９文字を出力
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
}

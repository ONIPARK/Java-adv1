package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount{
    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
     public boolean withdraw(int amount) {
        log("取引開始：" + amount + ", 残高： " + balance);

        synchronized(this) {
            log("[検証開始]：" + amount + ", 残高： " + balance);
            if (balance < amount) {
                log("[検証失敗]：" + amount + ", 残高： " + balance);
                return false;
            }
            log("[検証完了]：" + amount + ", 残高： " + balance);
            sleep(1000);
            balance = balance - amount;
            log("[出金完了]：" + amount + ", 変更残高： " + balance);
        }

        log("[検証終了]");
        return true;
    }

    @Override
    synchronized public int getBalance() {
        return balance;
    }
}

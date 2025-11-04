package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {
    private int balance;
    //volatile private int balance;


    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("取引開始: " + amount + ", 残額: " + balance);

        log("[ 検証開始 ] 出金額: " + amount + ", 残額: " + balance);
        if (balance < amount) {
            log("[ 検証失敗] 出金額: " + amount + ", 残額: " + balance);
            return false;
        }
        log("[ 検証完了 ] 出金額: " + amount + ", 残額: " + balance);
        sleep(1000); // 出金にかかる時間だと仮定する
        balance = balance - amount;
        log("[ 出勤完了 ] 出金額: " + amount + ", 変更金額: " + balance);

        log("取引終了");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

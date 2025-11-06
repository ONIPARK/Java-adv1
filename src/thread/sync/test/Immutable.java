package thread.sync.test;

public class Immutable {

    private final int value; // フィールドに final を貼っておくとどんなスレッドも値を変更できない。

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

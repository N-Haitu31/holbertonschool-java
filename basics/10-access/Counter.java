public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public Counter(int value) {
        this.value = value;
    }

    public void increment() {
        this.value += 1;
    }

    public int getValue() {
        return value;
    }

    void reset() {
        value = 0;
    }

    protected String describe() {
        return "Counter[value=" + value + "]";
    }
}

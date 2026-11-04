public class Scope {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.increment();
        System.out.println("Counter: " + counter.getValue());

        int x = 10;
        {
            int y = 5;
            x = x + y;
        }
        System.out.println("x = " + x);

        // System.out.println(y);
        // 10-access/Scope.java:16: error: cannot find symbol
        //         System.out.println(y);
        //                            ^
        //   symbol:   variable y
        //   location: class Scope
        // 1 error

        // counter.value = 42;
        // 10-access/Scope.java:24: error: value has private access in Counter
        //         counter.value = 42;
        //                ^
        // 1 error
    }
}

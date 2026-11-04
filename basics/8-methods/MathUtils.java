public class MathUtils {
    public static void main(String[] args) {
        System.out.println(max(3, 9));
        System.out.println(max(1, 2, 3, 4));
        System.out.println(isPrime(2147483647));
        System.out.println(gcd(12, 18));
        System.out.println(power(2, 40));
        System.out.println(fibonacci(10));
    }
    
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    public static int max(int... values) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > result) {
                result = values[i];
            }
        }
        return result;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long power(int base, int exponent) {
        if (exponent < 0) {
            return -1;
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

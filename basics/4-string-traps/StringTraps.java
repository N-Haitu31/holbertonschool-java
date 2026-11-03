public class StringTraps {
    public static void main(String[] args) {
        System.out.println("literals ==: " + sameObject("java", "java"));
        System.out.println("new String ==: " + sameObject("java", new String("java")));
        System.out.println("equals: " + sameContent("java", new String("java")));
        long startSlow = System.nanoTime();
        buildSlow(100_000);
        long endSlow = System.nanoTime();
        long slowMs = (endSlow - startSlow) / 1_000_000;

        long startFast = System.nanoTime();
        buildFast(100_000);
        long endFast = System.nanoTime();
        long fastMs = (endFast - startFast) / 1_000_000;

        System.out.println("slow: " + slowMs + " ms");
        System.out.println("fast: " + fastMs + " ms");
    }

    public static boolean sameObject(String a, String b) {
        return a == b;
    }

    public static boolean sameContent(String a, String b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    public static String repeat(String s, int times, String separator) {
        if (times <= 0 || s == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            if (i > 0 && separator != null) {
                sb.append(separator);
            }
            sb.append(s);
        }
        return sb.toString();
    }

    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

    public static String buildSlow(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += (char) ('a' + i % 26);
        }
        return result;
    }

    public static String buildFast(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append((char) ('a' + i % 26));
        }
        return sb.toString();
    }
}

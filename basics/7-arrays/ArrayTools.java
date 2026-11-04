public class ArrayTools {
    public static void main(String[] args) {
        int[] tab = {4, 8, 1};
        System.out.println(tab);
        System.out.println(java.util.Arrays.toString(tab));
    }

    public static int max(int[] t) {
        int result = t[0];
        for (int i = 1; i < t.length; i++) {
            if (t[i] > result) {
                result = t[i];
            }
        }
        return result;
    }

    public static double average(int[] t) {
        if (t.length == 0) {
            return 0.0;
        }
        long sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return (double) sum / t.length;
    }

    public static void reverseInPlace(int[] t) {
        for (int i = 0; i < t.length / 2; i++) {
            int temp = t[i];
            t[i] = t[t.length - 1 - i];
            t[t.length - 1 - i] = temp;
        }
    }

    public static int min(int[] t) {
        int result = t[0];
        for (int i = 1; i < t.length; i++) {
            if (t[i] < result) {
                result = t[i];
            }
        }
        return result;
    }

    public static int indexOf(int[] t, int value) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int[][] identity(int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
        }
        return m;
    }

    public static String format(int[][] m) {
        String result = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result += m[i][j];
                if (j < m[i].length - 1) {
                    result += " ";
                }
            }
            if (i < m.length - 1) {
                result += "\n";
            }
        }
        return result;
    }
}

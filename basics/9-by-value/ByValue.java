public class ByValue {
    public static void main(String[] args) {
        System.out.println(demoPrimitive());
        System.out.println(java.util.Arrays.toString(demoArrayContent()));
        System.out.println(java.util.Arrays.toString(demoArrayReassign()));
    }

    public static void doubleIt(int x) {
    x = x * 2;
    }

    public static void fillWithZeros(int[] t) {
        for (int i = 0; i < t.length; i++) {
            t[i] = 0;
        }
    }

    public static void swapInArray(int[] t, int i, int j) {
        int temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }

    public static void replaceArray(int[] t) {
        t = new int[]{9, 9, 9};
    }

    public static int demoPrimitive() {
    int n = 10;
    doubleIt(n);
    return n;
    }

    public static int[] demoArrayContent() {
        int[] t = {1, 2, 3};
        fillWithZeros(t);
        return t;
    }

    public static int[] demoArrayReassign() {
        int[] t = {1, 2, 3};
        replaceArray(t);
        return t;
    }
}

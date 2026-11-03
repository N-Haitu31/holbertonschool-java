public class Strings {
    public static void main(String[] args) {
        System.out.println(capitalize("hELLO wORLD"));
        System.out.println(countWords(" the cat sleeps "));
        System.out.println(initials("jean pierre dupont"));
        System.out.println(isPalindrome("Radar"));
        System.out.println(isPalindrome("A man a plan a canal Panama"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome(""));
        System.out.println(extractDomain("student@holbertonschool.com"));
        System.out.println(extractDomain("ada@x.com"));
        System.out.println(extractDomain("nobody"));
    }

    public static String capitalize(String s) {
        if (s.isEmpty()) {
            return "";
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static int countWords(String s) {
        String[] parts = s.split(" ");
        int count = 0;
        for (String part : parts) {
            if (!part.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static String initials(String s) {
        String[] parts = s.split(" ");
        String result = "";
        for (String part : parts) {
            if (!part.isEmpty()) {
                result = result + part.substring(0, 1).toUpperCase();
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        String cleaned = s.replace(" ", "").toLowerCase();
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed = reversed + cleaned.charAt(i);
        }
        return cleaned.equals(reversed);
    }

    public static String extractDomain(String email) {
        int position = email.indexOf("@");
        if (position == -1) {
            return "";
        }
        return email.substring(position + 1);
    }
}

import java.util.Scanner;

public class Interactive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number:");
            if (!sc.hasNextLine()) {
                break;
            }
            String line = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(line);
                System.out.println("Doubled: " + 2 * n);
                return;
            } catch (NumberFormatException e) {
                System.out.println("Invalid: \"" + line + "\"");
            }
        }

        System.err.println("Error: no valid input");
        System.exit(1);
    }
}

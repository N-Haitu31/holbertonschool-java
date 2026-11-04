public class Ticket {
    public static final String PREFIX = "TCK-";
    private static int nextId = 1;
    private final int id;

    public Ticket() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return PREFIX + String.format("%04d", id);
    }

    public static int getTotalTickets() {
        return nextId - 1;
    }

    public static boolean isValidCode(String code) {
        if (code == null) {
            return false;
        }
        return code.matches("TCK-\\d{4}");
    }
}

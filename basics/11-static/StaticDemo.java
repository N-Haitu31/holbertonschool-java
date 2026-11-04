public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("Before: " + Ticket.getTotalTickets());
        Ticket a = new Ticket();
        Ticket b = new Ticket();
        System.out.println(a.getCode() + " " + b.getCode());
        System.out.println("After: " + Ticket.getTotalTickets());

        // System.out.println(this);
        // 11-static/StaticDemo.java:9: error: non-static variable this cannot be referenced from a static context
        //         System.out.println(this);
        //                            ^
        // 1 error
    }
}

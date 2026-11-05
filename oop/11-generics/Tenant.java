public class Tenant implements Identifiable {
    private static final int INCOME_RATIO = 3;

    private final Contact contact;
    private final int monthlyIncome;

    public Tenant(Contact contact, int monthlyIncome) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact must not be null");
        }
        if (monthlyIncome < 0) {
            throw new IllegalArgumentException("Income must not be negative: " + monthlyIncome);
        }
        this.contact = contact;
        this.monthlyIncome = monthlyIncome;
    }

    public Contact getContact() {
        return contact;
    }

    public String getName() {
        return contact.name();
    }

    public String getEmail() {
        return contact.email();
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public boolean canAfford(int monthlyCost) {
        return monthlyIncome >= INCOME_RATIO * monthlyCost;
    }

    @Override
    public String getId() {
        return getEmail();
    }
}

import java.util.Objects;

public class Property {
    private final String reference;
    private Address address;
    private int surface;
    private int monthlyRent;

    public Property(String reference, Address address, int surface, int monthlyRent) {
        this.reference = checkReference(reference);
        this.address = checkAddress(address);
        this.surface = checkSurface(surface);
        this.monthlyRent = checkMonthlyRent(monthlyRent);
    }

    public String getReference() {
        return reference;
    }

    public Address getAddress() {
        return address;
    }

    public int getSurface() {
        return surface;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public int getAnnualRent() {
        return 12 * monthlyRent;
    }

    public void setAddress(Address address) {
        this.address = checkAddress(address);
    }

    public void setSurface(int surface) {
        this.surface = checkSurface(surface);
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = checkMonthlyRent(monthlyRent);
    }

    private static String checkReference(String reference) {
        if (reference == null || !reference.matches("P-\\d{3}")) {
            throw new IllegalArgumentException("Invalid reference: " + reference);
        }
        return reference;
    }

    private static Address checkAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        return address;
    }

    private static int checkSurface(int surface) {
        if (surface <= 0) {
            throw new IllegalArgumentException("Surface must be positive: " + surface);
        }
        return surface;
    }

    private static int checkMonthlyRent(int monthlyRent) {
        if (monthlyRent < 0) {
            throw new IllegalArgumentException("Rent must not be negative: " + monthlyRent);
        }
        return monthlyRent;
    }

    @Override
    public String toString() {
        return reference + " | " + surface + " m2 | " + monthlyRent + " EUR/month | " + address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true; // même objet
        }
        if (o == null || getClass() != o.getClass()) {
            return false; // null ou autre type : pas d'exception
        }
        Property other = (Property) o; // cast sûr, le type est vérifié
        return reference.equals(other.reference);
    }
}

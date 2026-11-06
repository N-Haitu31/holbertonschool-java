import java.util.Objects;

public abstract class Property implements Insurable, Comparable<Property>, Identifiable {
    private static final int CHARGES_PER_M2 = 2;

    private final String reference;
    private Address address;
    private int surface;
    private int monthlyRent;
    private EnergyClass energyClass;
    private Owner owner;
    private Tenant tenant;

    protected Property(String reference, Address address, int surface, int monthlyRent,
            EnergyClass energyClass) {
        this.reference = checkReference(reference);
        this.address = checkAddress(address);
        this.surface = checkSurface(surface);
        this.monthlyRent = checkMonthlyRent(monthlyRent);
        this.energyClass = checkEnergyClass(energyClass);
    }

    // ----- Getters -----

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

    public EnergyClass getEnergyClass() {
        return energyClass;
    }

    public Owner getOwner() {
        return owner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public boolean isRentable() {
        return energyClass.isRentable();
    }

    public boolean isRented() {
        return tenant != null;
    }

    // ----- Setters -----

    public void setAddress(Address address) {
        this.address = checkAddress(address);
    }

    public void setSurface(int surface) {
        this.surface = checkSurface(surface);
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = checkMonthlyRent(monthlyRent);
    }

    public void setEnergyClass(EnergyClass energyClass) {
        this.energyClass = checkEnergyClass(energyClass);
    }

    public void setOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner must not be null");
        }
        this.owner = owner;
    }

    // ----- Location -----

    public void rentTo(Tenant tenant) {
        if (tenant == null) {
            throw new IllegalArgumentException("Tenant must not be null");
        }
        if (isRented()) {
            throw new PropertyUnavailableException(reference, "already rented");
        }
        if (!isRentable()) {
            throw new PropertyUnavailableException(reference, "energy class G");
        }
        this.tenant = tenant;
    }

    public void release() {
        if (!isRented()) {
            throw new IllegalStateException(reference + " is not rented");
        }
        this.tenant = null;
    }

    // ----- Méthodes abstraites et calculs -----

    public abstract String getType();

    public abstract int getMonthlyCharges();

    protected int getCommonCharges() {
        return surface * CHARGES_PER_M2;
    }

    public final int getMonthlyCost() {
        return monthlyRent + getMonthlyCharges();
    }

    // ----- Méthodes de validation (privées) -----

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

    private static EnergyClass checkEnergyClass(EnergyClass energyClass) {
        if (energyClass == null) {
            throw new IllegalArgumentException("Energy class must not be null");
        }
        return energyClass;
    }

    // ----- Méthodes d'Object et Comparable -----

    @Override
    public int compareTo(Property other) {
        return reference.compareTo(other.reference);
    }

    @Override
    public String toString() {
        return getType() + " " + reference + " | " + surface + " m2 | " + monthlyRent
                + " EUR/month | " + address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Property other = (Property) o;
        return reference.equals(other.reference);
    }

    @Override
    public String getId() {
        return reference;
    }
}

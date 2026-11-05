public class Apartment extends Property {
    private static final int ELEVATOR_CHARGES = 40;

    private final int floor;
    private final boolean hasElevator;

    public Apartment(String reference, Address address, int surface, int monthlyRent,
            EnergyClass energyClass, int floor, boolean hasElevator) {
        super(reference, address, surface, monthlyRent, energyClass);
        if (floor < 0) {
            throw new IllegalArgumentException("Floor must not be negative: " + floor);
        }
        this.floor = floor;
        this.hasElevator = hasElevator;
    }

    public int getFloor() {
        return floor;
    }

    public boolean hasElevator() {
        return hasElevator;
    }

    @Override
    public String getType() {
        return "Apartment";
    }

    @Override
    public int getMonthlyCharges() {
        return getCommonCharges() + (hasElevator ? ELEVATOR_CHARGES : 0);
    }

    @Override
    public String toString() {
        return super.toString() + " | floor " + floor
                + (hasElevator ? ", elevator" : ", no elevator");
    }
}

public class CommercialSpace extends Property {
    private static final int CHARGES_FACTOR = 2;
    private static final int INSURED_VALUE_PER_M2 = 2000;
    private static final int PREMIUM_FACTOR = 2;

    private final String activity;

    public CommercialSpace(String reference, Address address, int surface, int monthlyRent,
            EnergyClass energyClass, String activity) {
        super(reference, address, surface, monthlyRent, energyClass);
        if (activity == null || activity.isBlank()) {
            throw new IllegalArgumentException("Activity must not be blank");
        }
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String getType() {
        return "Commercial space";
    }

    @Override
    public int getMonthlyCharges() {
        return CHARGES_FACTOR * getCommonCharges();
    }

    @Override
    public String toString() {
        return super.toString() + " | activity: " + activity;
    }

    @Override
    public int getInsuredValue() {
        return getSurface() * INSURED_VALUE_PER_M2;
    }

    @Override
    public int getYearlyInsurancePremium() {
        return PREMIUM_FACTOR * super.getYearlyInsurancePremium();
    }
}

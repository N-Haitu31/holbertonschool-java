public interface Insurable {
    int MIN_PREMIUM = 150;
    int PREMIUM_PER_THOUSAND = 3;

    int getInsuredValue();

    default int getYearlyInsurancePremium() {
        int premium = getInsuredValue() * PREMIUM_PER_THOUSAND / 1000;
        return Math.max(premium, MIN_PREMIUM);
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Property[] properties = {
                new CommercialSpace("P-010", new Address("1 Place Bellecour", "69002", "Lyon"),
                        80, 2500, EnergyClass.C, "bakery"),
                new Apartment("P-002", new Address("12 Rue de la Paix", "75002", "Paris"),
                        25, 950, EnergyClass.D, 3, true),
                new House("P-003", new Address("8 Chemin des Vignes", "33000", "Bordeaux"),
                        120, 1800, EnergyClass.B, 400)
        };

        int total = 0;
        for (Property p : properties) {
            System.out.println(p.getClass().getSimpleName() + " " + p.getReference()
                    + ": " + p.getMonthlyCost() + " EUR/month");
            total += p.getMonthlyCost();
        }
        System.out.println("Total: " + total + " EUR/month");
    }
}

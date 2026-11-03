public class Variables {
    public static void main(String[] args) {
        System.out.printf("byte: %d %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short: %d %d%n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int: %d %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long: %d %d%n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("float: %s %s%n", Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("double: %s %s%n", Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.printf("char: %d %d%n", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        System.out.printf("boolean: %b %b%n", Boolean.FALSE, Boolean.TRUE);
        // overflow - MAX_VALUE + 1 ne lève pas d'erreur ; le int fait 32 bits, donc la valeur « boucle » vers le minimum
        System.out.printf("overflow: %d%n", Integer.MAX_VALUE + 1);
        // precision - 0.1 et 0.2 n'ont pas de représentation binaire exacte, l'erreur d'approximation apparaît dans le résultat
        System.out.printf("precision: %s%n", 0.1 + 0.2);
        // truncation - le cast (int) coupe la partie décimale, il n'arrondit pas
        System.out.printf("truncation: %d%n", (int) 3.99);
        // promotion - int + long : l'int est promu en long avant l'addition, donc pas de dépassement
        int promotion = Integer.MAX_VALUE;
        long result = promotion + 1L;
        System.out.printf("promotion: %d%n", result);
    }
}

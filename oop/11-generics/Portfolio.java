import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private final List<Property> properties = new ArrayList<>();

    public boolean add(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("Property must not be null");
        }
        if (properties.contains(property)) {
            return false;
        }
        properties.add(property);
        return true;
    }

    public boolean remove(String reference) {
        Property found = findByReference(reference);
        if (found == null) {
            return false;
        }
        properties.remove(found);
        return true;
    }

    public Property findByReference(String reference) {
        for (Property p : properties) {
            if (p.getReference().equals(reference)) {
                return p;
            }
        }
        return null;
    }

    public int size() {
        return properties.size();
    }

    public List<Property> getProperties() {
        return new ArrayList<>(properties);
    }

    public List<Property> getVacant() {
        List<Property> result = new ArrayList<>();
        for (Property p : properties) {
            if (!p.isRented()) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Property> findByCity(String city) {
        List<Property> result = new ArrayList<>();
        for (Property p : properties) {
            if (p.getAddress().city().equalsIgnoreCase(city)) {
                result.add(p);
            }
        }
        return result;
    }

    public int getTotalMonthlyRent() {
        int total = 0;
        for (Property p : properties) {
            total += p.getMonthlyRent();
        }
        return total;
    }

    public int getMonthlyIncome() {
        int total = 0;
        for (Property p : properties) {
            if (p.isRented()) {
                total += p.getMonthlyRent();
            }
        }
        return total;
    }
    
    public int getOccupancyRate() {
        if (properties.isEmpty()) {
            return 0;
        }
        int rented = 0;
        for (Property p : properties) {
            if (p.isRented()) {
                rented++;
            }
        }
        return rented * 100 / properties.size();
    }
}

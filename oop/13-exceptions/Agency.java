import java.util.ArrayList;
import java.util.List;

public class Agency {
    private static final int MIN_DURATION = 12;
    private static final int MAX_DURATION = 36;

    private final Portfolio portfolio;
    private final List<Lease> leases = new ArrayList<>();

    public Agency(Portfolio portfolio) {
        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio must not be null");
        }
        this.portfolio = portfolio;
    }

    public Lease signLease(String reference, Tenant tenant, int durationMonths)
            throws InvalidLeaseException {
        if (tenant == null) {
            throw new IllegalArgumentException("Tenant must not be null");
        }
        Property property = portfolio.findByReference(reference);
        if (property == null) {
            throw new InvalidLeaseException("Unknown property: " + reference);
        }
        if (durationMonths < MIN_DURATION || durationMonths > MAX_DURATION) {
            throw new InvalidLeaseException("Invalid duration: " + durationMonths + " months");
        }
        if (!tenant.canAfford(property.getMonthlyCost())) {
            throw new InvalidLeaseException("Insufficient income: " + tenant.getName());
        }
        property.rentTo(tenant);
        Lease lease = new Lease(property, tenant, durationMonths);
        leases.add(lease);
        return lease;
    }

    public void endLease(String reference) throws InvalidLeaseException {
        for (Lease lease : leases) {
            if (lease.property().getReference().equals(reference)) {
                lease.property().release();
                leases.remove(lease);
                return;
            }
        }
        throw new InvalidLeaseException("No lease for: " + reference);
    }

    public List<Lease> getLeases() {
        return new ArrayList<>(leases);
    }
}

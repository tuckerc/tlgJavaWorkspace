package gov.irs;

public enum IRS {
    INSTANCE;

    private IRS() {
        System.out.println("IRS ctor");
    }

    public static IRS getInstance() {
        return INSTANCE;
    }

    public void collectTaxes() {

    }

    public void registerTaxPayer() {

    }
}

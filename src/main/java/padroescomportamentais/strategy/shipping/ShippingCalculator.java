package padroescomportamentais.strategy.shipping;

public class ShippingCalculator {

    private final Parcel parcel;

    public ShippingCalculator(Parcel parcel) {
        this.parcel = parcel;
    }

    public double calculate(ShippingStrategy strategy) {
        return strategy.calculate(parcel);
    }
}

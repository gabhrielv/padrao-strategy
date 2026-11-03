package padroescomportamentais.strategy.shipping;

/** Standard: base fee plus a rate per kg and per km. */
public class StandardShipping implements ShippingStrategy {

    public double calculate(Parcel parcel) {
        return 10.0 + parcel.getWeight() * 2.0 + parcel.getDistance() * 0.10;
    }
}

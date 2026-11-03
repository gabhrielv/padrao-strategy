package padroescomportamentais.strategy.shipping;

/** Same day: flat fee plus a rate per kg. */
public class SameDayShipping implements ShippingStrategy {

    public double calculate(Parcel parcel) {
        return 50.0 + parcel.getWeight() * 2.0;
    }
}

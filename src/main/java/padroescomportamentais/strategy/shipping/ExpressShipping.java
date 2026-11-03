package padroescomportamentais.strategy.shipping;

/** Express: twice the standard fee and rates. */
public class ExpressShipping implements ShippingStrategy {

    public double calculate(Parcel parcel) {
        return 20.0 + parcel.getWeight() * 4.0 + parcel.getDistance() * 0.20;
    }
}

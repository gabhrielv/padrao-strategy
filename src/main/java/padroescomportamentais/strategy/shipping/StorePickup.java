package padroescomportamentais.strategy.shipping;

/** Store pickup: always free. */
public class StorePickup implements ShippingStrategy {

    public double calculate(Parcel parcel) {
        return 0.0;
    }
}

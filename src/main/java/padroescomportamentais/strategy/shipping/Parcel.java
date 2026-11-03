package padroescomportamentais.strategy.shipping;

public class Parcel {

    private final String description;
    private final double weight;
    private final double distance;

    public Parcel(String description, double weight, double distance) {
        this.description = description;
        this.weight = weight;
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return description;
    }
}

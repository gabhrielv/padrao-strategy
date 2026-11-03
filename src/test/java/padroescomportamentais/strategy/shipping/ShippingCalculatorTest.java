package padroescomportamentais.strategy.shipping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingCalculatorTest {

    // Each strategy yields a different price, so a wrong strategy can't pass by accident.
    // Parcel: 5 kg, 20 km away.
    //   standard -> 10 + 5 * 2 + 20 * 0.10 = 22.0
    //   express  -> 20 + 5 * 4 + 20 * 0.20 = 44.0
    //   same day -> 50 + 5 * 2             = 60.0
    //   pickup   -> 0.0
    private static final double DELTA = 0.0001;

    private Parcel parcel;
    private ShippingCalculator calculator;

    @BeforeEach
    void setUp() {
        parcel = new Parcel("book", 5.0, 20.0);
        calculator = new ShippingCalculator(parcel);
    }

    @Test
    void shouldCalculateStandardShipping() {
        assertEquals(22.0, calculator.calculate(new StandardShipping()), DELTA);
    }

    @Test
    void shouldCalculateExpressShipping() {
        assertEquals(44.0, calculator.calculate(new ExpressShipping()), DELTA);
    }

    @Test
    void shouldCalculateSameDayShipping() {
        assertEquals(60.0, calculator.calculate(new SameDayShipping()), DELTA);
    }

    @Test
    void shouldBeFreeForStorePickup() {
        assertEquals(0.0, calculator.calculate(new StorePickup()), DELTA);
    }

    @Test
    void shouldSwapStrategyOnTheSameCalculator() {
        assertEquals(22.0, calculator.calculate(new StandardShipping()), DELTA);
        assertEquals(44.0, calculator.calculate(new ExpressShipping()), DELTA);
    }

    @Test
    void shouldNotModifyTheParcel() {
        calculator.calculate(new StandardShipping());
        calculator.calculate(new ExpressShipping());
        calculator.calculate(new SameDayShipping());
        calculator.calculate(new StorePickup());
        assertEquals("book", parcel.getDescription());
        assertEquals(5.0, parcel.getWeight(), DELTA);
        assertEquals(20.0, parcel.getDistance(), DELTA);
    }

    @Test
    void shouldChargeOnlyTheBaseFeeForZeroWeightAndDistance() {
        ShippingCalculator empty = new ShippingCalculator(new Parcel("letter", 0.0, 0.0));
        assertEquals(10.0, empty.calculate(new StandardShipping()), DELTA);
    }

    @Test
    void shouldGiveTheSamePriceForEqualParcels() {
        ShippingCalculator first = new ShippingCalculator(new Parcel("first", 3.0, 15.0));
        ShippingCalculator second = new ShippingCalculator(new Parcel("second", 3.0, 15.0));

        assertEquals(first.calculate(new ExpressShipping()), second.calculate(new ExpressShipping()), DELTA);
    }
}

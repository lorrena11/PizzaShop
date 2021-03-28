package pizza_shop.pizza;

import pizza_shop.service.PizzaPriceCalculator;
import pizza_shop.service.PizzaPriceCalculatorImpl;

import java.math.BigDecimal;

/**
 * Abstract implementation of pizza
 */
public abstract class Pizza implements PizzaAttributes, SupplyIntervalCalculator {

    private PizzaPriceCalculator pizzaPriceCalculator = new PizzaPriceCalculatorImpl(); // DON'T REMOVE IT. USE IT!

    public Pizza(PizzaSize pizzaSize, BigDecimal smallPrice, BigDecimal mediumPrice, BigDecimal largePrice) {

    }

    @Override
    public BigDecimal getPrice() {
        // THIS IS THE PLACE FOR THIS METHOD. USE IT HERE!
    }

    // IMPLEMENT
}

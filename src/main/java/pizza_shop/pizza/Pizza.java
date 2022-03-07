package pizza_shop.pizza;

import pizza_shop.service.PizzaPriceCalculator;
import pizza_shop.service.PizzaPriceCalculatorImpl;

import java.math.BigDecimal;

/**
 * Abstract implementation of pizza
 */
public abstract class Pizza implements PizzaAttributes, SupplyIntervalCalculator {

    private PizzaPriceCalculator pizzaPriceCalculator = new PizzaPriceCalculatorImpl(); // DON'T REMOVE IT. USE IT!
    private PizzaSize pizzaSize;
    private BigDecimal smallPrice;
    private BigDecimal mediumPrice;
    private BigDecimal largePrice;

    public Pizza(PizzaSize pizzaSize, BigDecimal smallPrice, BigDecimal mediumPrice, BigDecimal largePrice) {
        this.pizzaSize = pizzaSize;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public BigDecimal getSmallPrice() {
        return smallPrice;
    }


    public BigDecimal getMediumPrice() {
        return mediumPrice;
    }


    public BigDecimal getLargePrice() {
        return largePrice;
    }

    @Override
    public PizzaSize getSize() {
        return pizzaSize;
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = pizzaPriceCalculator.calculatePrice(this);
        return price;
    }

//    @Override
//    public String toString() {
//        return "Yummy pizza!";
//    }
}

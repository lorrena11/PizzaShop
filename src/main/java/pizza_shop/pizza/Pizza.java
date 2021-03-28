package pizza_shop.pizza;

import pizza_shop.service.PizzaPriceCalculator;

import java.math.BigDecimal;

public abstract class Pizza implements PizzaAttributes, SupplyIntervalCalculator {

    private PizzaSize pizzaSize;
    private BigDecimal smallPrice;
    private BigDecimal mediumPrice;
    private BigDecimal largePrice;
    private PizzaPriceCalculator pizzaPriceCalculator = new PizzaPriceCalculator();

    public Pizza(PizzaSize pizzaSize, BigDecimal smallPrice, BigDecimal mediumPrice, BigDecimal largePrice) {
        this.pizzaSize = pizzaSize;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    @Override
    public PizzaSize getSize() {
        return pizzaSize;
    }

    @Override
    public BigDecimal getPrice() {
        return pizzaPriceCalculator.calculatePrice(this);
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
}

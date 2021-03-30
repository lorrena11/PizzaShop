package pizza_shop.service;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;

public class PizzaPriceCalculatorImpl implements PizzaPriceCalculator {

    @Override
    public BigDecimal calculatePrice(Pizza pizza) {
        // This function should determine the price of the given pizza. If pizza is small -> one price, if medium, another etc
        BigDecimal price;
        if (pizza.getSize().equals(PizzaSize.SMALL)) price = pizza.getSmallPrice();
        else if (pizza.getSize().equals(PizzaSize.MEDIUM)) price = pizza.getMediumPrice();
        else price = pizza.getLargePrice();
        return price;
    }
}

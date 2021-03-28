package pizza_shop.service;

import pizza_shop.exception.PizzaSizeNotSupportedException;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;

/**
 * Service that calculates the price of a single pizza
 */
public class PizzaPriceCalculator {

    /**
     * 1. Užduotis
     * Determines the price of the pizza by its size. If the size is not known it should throw an exception
     * that pizza size is not supported
     * @param pizza which price needs to be calculated
     * @return price of the given pizza
     */
    public BigDecimal calculatePrice(Pizza pizza) {
        if (pizza.getSize() == null) {
            throw new PizzaSizeNotSupportedException();
        }
        if (pizza.getSize().equals(PizzaSize.SMALL)) return pizza.getSmallPrice();
        if (pizza.getSize().equals(PizzaSize.MEDIUM)) return pizza.getMediumPrice();
        if (pizza.getSize().equals(PizzaSize.LARGE)) return pizza.getLargePrice();
        throw new PizzaSizeNotSupportedException();
    }
}

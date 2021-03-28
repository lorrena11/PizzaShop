package pizza_shop.service;

import pizza_shop.pizza.Pizza;

import java.math.BigDecimal;

/**
 * Service that calculates the price of a single pizza
 * DO NOT CHANGE ANYTHING IN THIS INTERFACE!
 */
public interface PizzaPriceCalculator {

    /**
     * 1. Užduotis
     * Determines the price of the pizza by its size. If the size is not known it should throw an exception
     * that pizza size is not supported
     * @param pizza which price needs to be calculated
     * @return price of the given pizza
     */
    BigDecimal calculatePrice(Pizza pizza);
}

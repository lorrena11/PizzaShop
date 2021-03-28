package pizza_shop.service;

import pizza_shop.exception.PizzaSizeNotSupportedException;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;

public class PizzaPriceCalculator {

    public BigDecimal calculatePrice(Pizza pizza) {
        return calculateRegularPrice(pizza);
    }

    private BigDecimal calculateRegularPrice(Pizza pizza) {
        if (pizza.getSize() == null) {
            throw new PizzaSizeNotSupportedException();
        }
        if (pizza.getSize().equals(PizzaSize.SMALL)) return pizza.getSmallPrice();
        if (pizza.getSize().equals(PizzaSize.MEDIUM)) return pizza.getMediumPrice();
        if (pizza.getSize().equals(PizzaSize.LARGE)) return pizza.getLargePrice();
        throw new PizzaSizeNotSupportedException();
    }
}

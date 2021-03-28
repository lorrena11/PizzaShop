package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Margarita extends Pizza {

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(3);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(4);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(7);

    // no supply needed
    public Margarita(PizzaSize pizzaSize) {
        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Margarita() {
        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    @Override
    public boolean needsSupply(LocalDate date) {
        return false;
    }

    @Override
    public boolean needsSupply() {
        return false;
    }
}

package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Peperonni implementation of the pizza
 * This pizza needs supply on Monday
 */
public class Peperonni extends Pizza {

    private DayOfWeek dayOfSupply = DayOfWeek.MONDAY;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(4);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(5);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(8);

    public Peperonni(PizzaSize pizzaSize) {
        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Peperonni() {
        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    @Override
    public boolean needsSupply(LocalDate date) {
        return false; // TODO: fix it
    }

    @Override
    public boolean needsSupply() {
        return false; // TODO: fix it
    }
}

package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Studentu implementation of the pizza
 * This pizza needs supply on Friday
 */

public class Studentu extends Pizza {

    private DayOfWeek dayOfSupply = DayOfWeek.FRIDAY;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(4);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(5.5);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(7.5);

    public Studentu(PizzaSize pizzaSize) {
        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Studentu() {
        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    @Override
    public boolean needsSupply(LocalDate date) {
        return date.getDayOfWeek().equals(dayOfSupply);
    }

    @Override
    public boolean needsSupply() {
        return false;
    }

}

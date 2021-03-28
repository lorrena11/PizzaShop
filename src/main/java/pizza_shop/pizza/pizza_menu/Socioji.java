package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Socioji implementation of the pizza
 * This pizza needs supply on Friday
 */
public class Socioji extends Pizza {

    private DayOfWeek dayOfSupply = DayOfWeek.FRIDAY;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(4.5);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(5.5);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(9);

    public Socioji(PizzaSize pizzaSize) {
        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Socioji() {
        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    @Override
    public boolean needsSupply(LocalDate serviceDate) {
        // returns true if given date is friday
        return serviceDate.getDayOfWeek().equals(dayOfSupply);
    }

    @Override
    public boolean needsSupply() {
        // true if today is friday
        return LocalDate.now().getDayOfWeek().equals(dayOfSupply);
    }
}

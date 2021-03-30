package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.DayOfWeek;

/**
 * Socioji implementation of the pizza
 * This pizza needs supply on Friday
 */
// TODO: you need to extend an abstract class
public class Socioji {

    private DayOfWeek dayOfSupply = DayOfWeek.FRIDAY;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(4.5);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(5.5);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(9);

    public Socioji(PizzaSize pizzaSize) {
//        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Socioji() {
//        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    // TODO: override necessary methods

}

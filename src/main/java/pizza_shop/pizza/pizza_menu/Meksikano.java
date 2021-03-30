package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.DayOfWeek;

/**
 * Meksikano implementation of the pizza
 * This pizza needs supply on Wednesday
 */
// TODO: you need to extend an abstract class
public class Meksikano {

    private DayOfWeek dayOfSupply = DayOfWeek.WEDNESDAY;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(5);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(6);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(9);

    public Meksikano(PizzaSize pizzaSize) {
//        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Meksikano() {
//        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    // TODO: override necessary methods


}
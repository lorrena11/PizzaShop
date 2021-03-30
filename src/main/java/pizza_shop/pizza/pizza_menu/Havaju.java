package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.DayOfWeek;

/**
 * Hawaii implementation of the pizza
 * This pizza needs supply on Wednesday
 */
// TODO: you need to extend an abstract class
public class Havaju {

    private DayOfWeek dayOfSupply = DayOfWeek.WEDNESDAY;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(4.5);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(5.5);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(8.5);

    public Havaju(PizzaSize pizzaSize) {
//        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Havaju() {
//        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }


    // TODO: override necessary methods
}

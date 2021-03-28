package pizza_shop.order;

import pizza_shop.pizza.Pizza;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Order interface. DO NOT CHANGE ANYTHING IN THIS INTERFACE!
 */
public interface Order {
    /**
     * @return List of pizzas in this order
     */
    List<Pizza> getPizzaList();

    /**
     * @return true if this order made by a student
     */
    boolean isStudentDiscount();

    /**
     * @return The date when the order was placed
     */
    LocalDate getPurchaseDate();

    /**
     * @return Total price of all pizzas in this order
     */
    BigDecimal getTotalPrice();
}

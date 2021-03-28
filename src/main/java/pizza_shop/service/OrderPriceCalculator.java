package pizza_shop.service;

import pizza_shop.order.Order;
import pizza_shop.pizza.Pizza;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.List;

/**
 * DO NOT CHANGE ANYTHING IN THIS INTERFACE!
 */
public interface OrderPriceCalculator {

    /**
     * 1. Užduotis
     * If the pizza list is empty it should throw an exception;
     * If pizza list has more or equal to minimum size for free pizza we give the cheapest one for free
     * @param pizzaList pizzas that customer ordered
     * @param isStudentDiscount determines whether the customer is student or not
     * @return total amount of the order
     */
    BigDecimal getOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount);

    /**
     * @param orders orders that pizza shop already has
     * @return average amount of the order
     */
    BigDecimal calculateAverageOrder(List<Order> orders);

    /**
     * @param orders orders that pizza shop already has
     * @param month  when the order was completed
     * @param year when the order was completed
     * @return average order price by the given period
     */
    BigDecimal calculateAverageOrderPeriod(List<Order> orders, Month month, Year year);

    /**
     * Determines if the order was made on the given month and year
     */
    boolean isOrderGivenMonth(Order o, Month month, Year year);
}

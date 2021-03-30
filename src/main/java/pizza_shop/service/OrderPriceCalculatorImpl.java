package pizza_shop.service;

import pizza_shop.order.Order;
import pizza_shop.pizza.Pizza;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
import java.util.List;

/**
 * Service that is responsible for order price calculation
 */
public class OrderPriceCalculatorImpl implements OrderPriceCalculator {

    private static final BigDecimal STUDENT_DISCOUNT = BigDecimal.ONE;
    private static final int MIN_PIZZA_FOR_FREE = 4;

    @Override
    public BigDecimal getOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount) {
       // CODE HERE! It should calculate the final price of the order
        return null;
    }

    @Override
    public BigDecimal calculateAverageOrder(List<Order> orders) {
        // CODE HERE! It should calculate average price of orders (total orders price / order count)
        return null;
    }

    @Override
    public BigDecimal calculateAverageOrderPeriod(List<Order> orders, Month month, Year year) {
        // CODE HERE! It should calculate average price total orders price / order count)
        // of the order for the given period. If we have orders in january and february but we provide that we
        // only counting average for february, we should filter january orders out
        return null;
    }

    @Override
    public boolean isOrderGivenMonth(Order o, Month month, Year year) {
        // CODE HERE! Verify whether the order was performed at the given dates. You can reuse this function later
        return false; // TODO: fix it
    }

    /**
     * @param pizzaList pizzas that were ordered
     * @param isStudentDiscount determines if the order was made by the student
     * @return total price of the order excluding cheapest pizza
     */
    private BigDecimal getFreePizzaOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount) {
       // YOU CAN REMOVE THIS METHOD IF YOU DON'T FIND IT USABLE AND YOU CAME UP WITH DIFFERENT SOLUTION.
        // Hint: use the comparator here.
        // This should determine the cheapest price of pizza and not include it in price calculation
        return null;
    }

    /**
     * @param pizzaList pizzas that were ordered
     * @param isStudentDiscount determines if the order was made by the student
     * @return total price of the order
     */
    private BigDecimal getRegularOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount) {
        // YOU CAN REMOVE THIS METHOD IF YOU DON'T FIND IT USABLE AND YOU CAME UP WITH DIFFERENT SOLUTION.
        // It should calculate regular order price. if it has a student discount, order should be cheaper
        // HINT: use loop here (or stream api)
        return null;
    }

    /**
     * Returns the price that needs to be paid by the customer. If customer has a student discount, we reduce the
     * price of the pizza by the amount that is declared as a student discount
     * @param pizza pizzas that were ordered
     * @param isStudentDiscount determines if the order was made by the student
     * @return final price of the pizze
     */
    private BigDecimal calculateFinalPrice(Pizza pizza, boolean isStudentDiscount) {
        // YOU CAN REMOVE THIS METHOD IF YOU DON'T FIND IT USABLE AND YOU CAME UP WITH DIFFERENT SOLUTION.
        // this method should calculate final price of a single pizza
        return null;
    }
}

package pizza_shop;

import pizza_shop.order.Order;
import pizza_shop.order.OrderImpl;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.pizza_menu.*;
import pizza_shop.service.OrderPriceCalculator;
import pizza_shop.service.OrderPriceCalculatorImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pizza shop class that is responsible for manipulation of the system
 */
public class PizzaShop {

    /**
     * List of pizzas that are available in this shop
     */
    private final List<Pizza> availablePizzas = List.of(
        new Havaju(),
        new Margarita(),
        new Meksikano(),
        new Peperonni(),
        new Socioji(),
        new Studentu(),
        new Vezuvijus()
        );

    /**
     * Calculator that needs to be used to calculate order price
     */
    private OrderPriceCalculator orderPriceCalculatorImpl = new OrderPriceCalculatorImpl();

    /**
     * All orders that were made in this pizza shop
     */
    private List<Order> orders = new ArrayList<>();

    /**
     * 1. Užduotis
     * @param pizzas that are being ordered (populates orders list)
     */
    public void placeOrder(List<Pizza> pizzas) {
        this.placeOrder(pizzas, false, LocalDate.now());
    }

    /**
     * 1. Užduotis
     * @param pizzas that are being ordered
     * @param isStudentDiscount whether the customer is a student
     */
    public void placeOrder(List<Pizza> pizzas, boolean isStudentDiscount) {
        this.placeOrder(pizzas, isStudentDiscount, LocalDate.now());
    }

    /**
     * 1. Užduotis
     * @param pizzas that are being ordered
     * @param orderDate date when the order was placed
     */
    public void placeHistoryOrder(List<Pizza> pizzas, LocalDate orderDate) {
        this.placeOrder(pizzas, false, orderDate);
    }

    /**
     * 1. Užduotis
     * @param pizzas that are being ordered
     * @param isStudentDiscount whether the customer is a student
     * @param orderDate date when the order was placed
     */
    public void placeOrder(List<Pizza> pizzas, boolean isStudentDiscount, LocalDate orderDate) {
        orders.add(new OrderImpl(pizzas, isStudentDiscount, orderDate));
    }

    /**
     * 2. Užduotis
     * Returns a list of pizzas that supplies need to be ordered now
     */
    public List<Pizza> getPizzaThatNeedSupplyNow() {
        return getPizzaThatNeedSupply(LocalDate.now());
    }

    /**
     * 2. Užduotis
     * Returns a list of pizzas that supplies need to be ordered by the given date
     */
    public List<Pizza> getPizzaThatNeedSupply(LocalDate localDate) {
        return availablePizzas.stream()
                .filter(p -> p.needsSupply(localDate))
                .collect(Collectors.toList());
    }

    /**
     * 3. Užduotis, part 1
     * @param month the month of which the revenue must be calculated
     * @param year the year where the month is in
     * @return The revenue of the pizza shop in the specified month and year given
     */
    public BigDecimal getRevenuePerMonth(Month month, Year year)
    {
        return orders.stream()
                .filter(o -> orderPriceCalculatorImpl.isOrderGivenMonth(o, month, year))
                .map(Order::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 3. Užduotis, part 2
     * Returns the number of students that placed the orders by the given period
     */
    public int getNumberOfStudentsOrders(Month month, Year year) {
        return (int) orders.stream()
                .filter(o -> orderPriceCalculatorImpl.isOrderGivenMonth(o, month, year))
                .filter(Order::isStudentDiscount)
                .count();
    }

    /**
     * 4. Užduotis, part 1
     * Calculates the price of all orders that ware placed in pizza shop
     */
    public BigDecimal getAverageOrderPrice() {
        return orderPriceCalculatorImpl.calculateAverageOrder(orders);
    }

    /**
     * 4. Užduotis, part 2
     * Calculates the price of all orders that ware placed in pizza shop by the given month and year
     */
    public BigDecimal getAverageOrderPrice(Month month, Year year) {
        return orderPriceCalculatorImpl.calculateAverageOrderPeriod(orders, month, year);
    }

    /**
     * 1. Užduotis
     * @return all available pizzas
     */
    public List<Pizza> getAvailablePizzas() {
        return availablePizzas;
    }

    /**
     * 1. Užduotis
     * @return orders that were placed in this pizza shop
     */
    public List<Order> getOrders() {
        return orders;
    }
}

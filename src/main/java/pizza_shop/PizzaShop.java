package pizza_shop;

import pizza_shop.order.Order;
import pizza_shop.order.OrderImpl;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.pizza_menu.*;
import pizza_shop.service.OrderPriceCalculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaShop {

    private List<Pizza> availablePizzas = List.of(
        new Havaju(),
        new Margarita(),
        new Meksikano(),
        new Peperonni(),
        new Socioji(),
        new Studentu(),
        new Vezuvijus()
        );

    private OrderPriceCalculator orderPriceCalculator = new OrderPriceCalculator();
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(List<Pizza> pizzas) {
        this.placeOrder(pizzas, false, LocalDate.now());
    }

    public void placeOrder(List<Pizza> pizzas, boolean isStudentDiscount) {
        this.placeOrder(pizzas, isStudentDiscount, LocalDate.now());
    }

    public void placeHistoryOrder(List<Pizza> pizzas, LocalDate orderDate) {
        this.placeOrder(pizzas, false, orderDate);
    }

    public void placeOrder(List<Pizza> pizzas, boolean isStudentDiscount, LocalDate orderDate) {
        orders.add(new OrderImpl(pizzas, isStudentDiscount, orderDate));
    }

    /**
     * 2. Užduotis
     */
    public List<Pizza> getPizzaThatNeedSupplyNow() {
        return getPizzaThatNeedSupply(LocalDate.now());
    }

    /**
     * 2. Užduotis
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
                .filter(o -> orderPriceCalculator.isOrderGivenMonth(o, month, year))
                .map(Order::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 3. Užduotis, part 2
     */
    public int getNumberOfStudentsOrders(Month month, Year year) {
        return (int) orders.stream()
                .filter(o -> orderPriceCalculator.isOrderGivenMonth(o, month, year))
                .filter(Order::isIsStudentDiscount)
                .count();
    }

    /**
     * 4. Užduotis, part 1
     */
    public BigDecimal getAverageOrderPrice() {
        return orderPriceCalculator.calculateAverageOrder(orders);
    }

    /**
     * 4. Užduotis, part 2
     */
    public BigDecimal getAverageOrderPrice(Month month, Year year) {
        return orderPriceCalculator.calculateAverageOrderPeriod(orders, month, year);
    }

    public List<Pizza> getAvailablePizzas() {
        return availablePizzas;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

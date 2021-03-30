package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.order.Order;
import pizza_shop.order.OrderImpl;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise4Test {
    private OrderPriceCalculator orderPriceCalculatorImpl = new OrderPriceCalculatorImpl();

    @Test
    void calculateAverageOrder() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        Order order1 = new OrderImpl(pizzas, true);
        Order order2 = new OrderImpl(pizzas, false);

        List<Order> orders = List.of(order1, order2);
        assertEquals(orderPriceCalculatorImpl.calculateAverageOrder(orders), BigDecimal.valueOf(6));
    }

    @Test
    void calculateAverageOrderPeriod() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        Order order1 = new OrderImpl(pizzas, true, LocalDate.of(2021, 1, 1));
        Order order2 = new OrderImpl(pizzas, false, LocalDate.of(2021, 1, 22));
        Order order3 = new OrderImpl(pizzas, false, LocalDate.of(2021, 3, 22));
        Order order4 = new OrderImpl(pizzas, false, LocalDate.of(2021, 2, 22));

        List<Order> orders = List.of(order1, order2, order3, order4);

        BigDecimal averageOrder = orderPriceCalculatorImpl.calculateAverageOrderPeriod(orders, Month.JANUARY, Year.of(2021));

        assertEquals(averageOrder, BigDecimal.valueOf(6));
    }
}

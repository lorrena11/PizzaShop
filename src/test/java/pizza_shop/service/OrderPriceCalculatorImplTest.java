package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.order.Order;
import pizza_shop.order.OrderImpl;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;
import pizza_shop.pizza.pizza_menu.Peperonni;
import pizza_shop.pizza.pizza_menu.Vezuvijus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;


class OrderPriceCalculatorTest {

    private OrderPriceCalculator orderPriceCalculator = new OrderPriceCalculator();

    @Test
    void getOrderPrice_regular() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculator.getOrderPrice(pizzas, false);
        assert orderPrice.equals(BigDecimal.valueOf(7));
    }

    @Test
    void getOrderPrice_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculator.getOrderPrice(pizzas, true);
        assert orderPrice.equals(BigDecimal.valueOf(5));
    }

    @Test
    void getOrderPrice_cheapest_free() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculator.getOrderPrice(pizzas, false);
        assert orderPrice.equals(BigDecimal.valueOf(17.5));
    }

    @Test
    void getOrderPrice_cheapest_free_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculator.getOrderPrice(pizzas, true);
        assert orderPrice.equals(BigDecimal.valueOf(14.5));
    }

    @Test
    void calculateAverageOrder() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        Order order1 = new OrderImpl(pizzas, true);
        Order order2 = new OrderImpl(pizzas, false);

        List<Order> orders = List.of(order1, order2);
        assert orderPriceCalculator.calculateAverageOrder(orders).equals(BigDecimal.valueOf(6));
    }

    @Test
    void isOrderGivenMonth() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        Order order1 = new OrderImpl(pizzas, true, LocalDate.of(2021, 1, 1));
        Order order2 = new OrderImpl(pizzas, false, LocalDate.of(2021, 1, 22));
        Order order3 = new OrderImpl(pizzas, false, LocalDate.of(2021, 3, 22));
        Order order4 = new OrderImpl(pizzas, false, LocalDate.of(2021, 2, 22));

        List<Order> orders = List.of(order1, order2, order3, order4);

        BigDecimal averageOrder = orderPriceCalculator.calculateAverageOrderPeriod(orders, Month.JANUARY, Year.of(2021));

        assert averageOrder.equals(BigDecimal.valueOf(6));
    }
}
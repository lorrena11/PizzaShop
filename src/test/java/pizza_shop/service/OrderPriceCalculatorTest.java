package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;
import pizza_shop.pizza.pizza_menu.Peperonni;
import pizza_shop.pizza.pizza_menu.Vezuvijus;

import java.math.BigDecimal;
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
}
package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;
import pizza_shop.pizza.pizza_menu.Peperonni;
import pizza_shop.pizza.pizza_menu.Vezuvijus;

import java.math.BigDecimal;
import java.util.List;

class PriceCalculatorTest {

    private PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    void calculatePrice() {
        Pizza margaritaSmall = new Margarita(PizzaSize.SMALL);
        Pizza margaritaMedium = new Margarita(PizzaSize.MEDIUM);
        Pizza margaritaLarge = new Margarita(PizzaSize.LARGE);

        BigDecimal smallPrice = priceCalculator.calculatePrice(margaritaSmall);
        BigDecimal mediumPrice = priceCalculator.calculatePrice(margaritaMedium);
        BigDecimal largePrice = priceCalculator.calculatePrice(margaritaLarge);

        assert margaritaSmall.getPrice().equals(smallPrice);
        assert margaritaMedium.getPrice().equals(mediumPrice);
        assert margaritaLarge.getPrice().equals(largePrice);
    }

    @Test
    void getOrderPrice_regular() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = priceCalculator.getOrderPrice(pizzas, false);
        assert orderPrice.equals(BigDecimal.valueOf(7));
    }

    @Test
    void getOrderPrice_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = priceCalculator.getOrderPrice(pizzas, true);
        assert orderPrice.equals(BigDecimal.valueOf(5));
    }

    @Test
    void getOrderPrice_cheapest_free() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = priceCalculator.getOrderPrice(pizzas, false);
        assert orderPrice.equals(BigDecimal.valueOf(17.5));
    }

    @Test
    void getOrderPrice_cheapest_free_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = priceCalculator.getOrderPrice(pizzas, true);
        assert orderPrice.equals(BigDecimal.valueOf(14.5));
    }
}
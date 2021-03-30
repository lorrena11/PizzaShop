package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.PizzaShop;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;
import pizza_shop.pizza.pizza_menu.Peperonni;
import pizza_shop.pizza.pizza_menu.Vezuvijus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pizza_shop.TestPizzaSupplier.getTestPizzas;

public class Exercise1Test {

    private OrderPriceCalculator orderPriceCalculatorImpl = new OrderPriceCalculatorImpl();
    private PizzaPriceCalculator pizzaPriceCalculatorImpl = new PizzaPriceCalculatorImpl();
    private PizzaShop pizzaShop = new PizzaShop();

    @Test
    void getOrderPrice_regular() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, false);
        assertEquals(orderPrice, BigDecimal.valueOf(7));
    }

    @Test
    void getOrderPrice_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, true);
        assertEquals(orderPrice, BigDecimal.valueOf(5));
    }

    @Test
    void getOrderPrice_cheapest_free() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, false);
        assertEquals(orderPrice, BigDecimal.valueOf(17.5));
    }

    @Test
    void getOrderPrice_cheapest_free_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, true);
        assertEquals(orderPrice, BigDecimal.valueOf(14.5));
    }

    @Test
    void placeOrder() {
        pizzaShop.placeOrder(getTestPizzas());
        pizzaShop.placeOrder(getTestPizzas());
        assertEquals(2, pizzaShop.getOrders().size());
    }

    @Test
    void testPlaceOrder() {
        pizzaShop.placeOrder(getTestPizzas(), true);
        assertEquals(1, pizzaShop.getOrders().size());
    }

    @Test
    void placeHistoryOrder() {
        LocalDate orderDate = LocalDate.of(2021, 1, 1);
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 1, 1));
        assertEquals(1, pizzaShop.getOrders().size());
        assertEquals(pizzaShop.getOrders().get(0).getPurchaseDate(), orderDate);
    }

    @Test
    void getPizzaThatNeedSupplyNow() {
        // skip since LocalDate.now() will be different every time
    }

    @Test
    void calculatePrice() {
        Pizza margaritaSmall = new Margarita(PizzaSize.SMALL);
        Pizza margaritaMedium = new Margarita(PizzaSize.MEDIUM);
        Pizza margaritaLarge = new Margarita(PizzaSize.LARGE);

        BigDecimal smallPrice = pizzaPriceCalculatorImpl.calculatePrice(margaritaSmall);
        BigDecimal mediumPrice = pizzaPriceCalculatorImpl.calculatePrice(margaritaMedium);
        BigDecimal largePrice = pizzaPriceCalculatorImpl.calculatePrice(margaritaLarge);

        assertEquals(margaritaSmall.getPrice(), smallPrice);
        assertEquals(margaritaMedium.getPrice(), mediumPrice);
        assertEquals(margaritaLarge.getPrice(), largePrice);
    }

    @Test
    void getAvailablePizzas() {
        assertEquals(7, pizzaShop.getAvailablePizzas().size());
    }
}

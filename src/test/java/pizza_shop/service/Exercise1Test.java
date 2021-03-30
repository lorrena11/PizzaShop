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

import static pizza_shop.TestPizzaSupplier.getTestPizzas;

public class Exercise1Test {

    private OrderPriceCalculator orderPriceCalculatorImpl = new OrderPriceCalculatorImpl();
    private PizzaPriceCalculator pizzaPriceCalculatorImpl = new PizzaPriceCalculatorImpl();
    private PizzaShop pizzaShop = new PizzaShop();

    @Test
    void getOrderPrice_regular() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, false);
        assert orderPrice.equals(BigDecimal.valueOf(7));
    }

    @Test
    void getOrderPrice_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, true);
        assert orderPrice.equals(BigDecimal.valueOf(5));
    }

    @Test
    void getOrderPrice_cheapest_free() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, false);
        assert orderPrice.equals(BigDecimal.valueOf(17.5));
    }

    @Test
    void getOrderPrice_cheapest_free_student() {
        List<Pizza> pizzas = List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM), new Peperonni(PizzaSize.LARGE), new Vezuvijus(PizzaSize.MEDIUM));

        BigDecimal orderPrice = orderPriceCalculatorImpl.getOrderPrice(pizzas, true);
        assert orderPrice.equals(BigDecimal.valueOf(14.5));
    }

    @Test
    void placeOrder() {
        pizzaShop.placeOrder(getTestPizzas());
        pizzaShop.placeOrder(getTestPizzas());
        assert pizzaShop.getOrders().size() == 2;
    }

    @Test
    void testPlaceOrder() {
        pizzaShop.placeOrder(getTestPizzas(), true);
        assert pizzaShop.getOrders().size() == 1;
    }

    @Test
    void placeHistoryOrder() {
        LocalDate orderDate = LocalDate.of(2021, 1, 1);
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 1, 1));
        assert pizzaShop.getOrders().size() == 1;
        assert pizzaShop.getOrders().get(0).getPurchaseDate().equals(orderDate);
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

        assert margaritaSmall.getPrice().equals(smallPrice);
        assert margaritaMedium.getPrice().equals(mediumPrice);
        assert margaritaLarge.getPrice().equals(largePrice);
    }

    @Test
    void getAvailablePizzas() {
        assert pizzaShop.getAvailablePizzas().size() == 7;
    }
}

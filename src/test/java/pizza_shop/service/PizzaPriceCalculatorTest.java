package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;

import java.math.BigDecimal;

class PizzaPriceCalculatorTest {

    private PizzaPriceCalculator pizzaPriceCalculator = new PizzaPriceCalculator();

    @Test
    void calculatePrice() {
        Pizza margaritaSmall = new Margarita(PizzaSize.SMALL);
        Pizza margaritaMedium = new Margarita(PizzaSize.MEDIUM);
        Pizza margaritaLarge = new Margarita(PizzaSize.LARGE);

        BigDecimal smallPrice = pizzaPriceCalculator.calculatePrice(margaritaSmall);
        BigDecimal mediumPrice = pizzaPriceCalculator.calculatePrice(margaritaMedium);
        BigDecimal largePrice = pizzaPriceCalculator.calculatePrice(margaritaLarge);

        assert margaritaSmall.getPrice().equals(smallPrice);
        assert margaritaMedium.getPrice().equals(mediumPrice);
        assert margaritaLarge.getPrice().equals(largePrice);
    }
}
package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;

import java.math.BigDecimal;

class PizzaPriceCalculatorImplTest {

    private PizzaPriceCalculator pizzaPriceCalculatorImpl = new PizzaPriceCalculatorImpl();

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
}
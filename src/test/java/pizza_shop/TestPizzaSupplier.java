package pizza_shop;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;

import java.util.List;

public class TestPizzaSupplier {
    public static List<Pizza> getTestPizzas() { // value is 7 eur
        return List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));
    }
}

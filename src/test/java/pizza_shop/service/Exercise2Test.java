package pizza_shop.service;

import org.junit.jupiter.api.Test;
import pizza_shop.PizzaShop;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;
import pizza_shop.pizza.pizza_menu.Peperonni;
import pizza_shop.pizza.pizza_menu.Vezuvijus;

import java.time.LocalDate;
import java.util.List;

public class Exercise2Test {

    private PizzaShop pizzaShop = new PizzaShop();

    @Test
    void getPizzaThatNeedSupply_not_needed() {
        List<Pizza> needSupplyTuesday = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 3, 30));
        Pizza margarita = new Margarita(PizzaSize.MEDIUM);

        assert needSupplyTuesday.size() == 0;
        assert !margarita.needsSupply(LocalDate.of(2021, 3, 30));
        assert !margarita.needsSupply();
    }

    @Test
    void getPizzaThatNeedSupply_monday() {
        List<Pizza> needSupplyMonday = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 3, 29));

        assert needSupplyMonday.size() == 1;
        assert needSupplyMonday.stream().anyMatch(c -> c instanceof Peperonni);
    }

    /**
     * 2. Uzduotis
     */
    @Test
    void getPizzaThatNeedSupply_wednesday() {
        List<Pizza> needSupply = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 3, 31));

        throw new AssertionError();
        // FIXME: uncomment below for tests
//        assert needSupply.size() == 2;
//        assert needSupply.stream().anyMatch(c -> c instanceof Havaju);
//        assert needSupply.stream().anyMatch(c -> c instanceof Meksikano);
    }

    /**
     * 2. Uzduotis
     */
    @Test
    void getPizzaThatNeedSupply_friday() {
        List<Pizza> needSupplyFriday = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 1, 1));


        throw new AssertionError();
        // FIXME: uncomment below for tests
//        assert needSupplyFriday.size() == 2;
//        assert needSupplyFriday.stream().anyMatch(c -> c instanceof Socioji);
//        assert needSupplyFriday.stream().anyMatch(c -> c instanceof Studentu);
    }

    @Test
    void getPizzaThatNeedSupply_saturday() {
        List<Pizza> needSupplyFriday = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 3, 27));

        assert needSupplyFriday.size() == 1;
        assert needSupplyFriday.stream().anyMatch(c -> c instanceof Vezuvijus);
    }
}

package pizza_shop;

import org.junit.jupiter.api.Test;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.*;

import java.time.LocalDate;
import java.util.List;

class PizzaShopTest {

    private PizzaShop pizzaShop = new PizzaShop();

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

    @Test
    void getPizzaThatNeedSupply_wednesday() {
        List<Pizza> needSupply = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 3, 31));

        assert needSupply.size() == 2;
        assert needSupply.stream().anyMatch(c -> c instanceof Havaju);
        assert needSupply.stream().anyMatch(c -> c instanceof Meksikano);
    }

    @Test
    void getPizzaThatNeedSupply_friday() {
        List<Pizza> needSupplyFriday = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 1, 1));

        assert needSupplyFriday.size() == 2;
        assert needSupplyFriday.stream().anyMatch(c -> c instanceof Socioji);
        assert needSupplyFriday.stream().anyMatch(c -> c instanceof Studentu);
    }

    @Test
    void getPizzaThatNeedSupply_saturday() {
        List<Pizza> needSupplyFriday = pizzaShop.getPizzaThatNeedSupply(LocalDate.of(2021, 3, 27));

        assert needSupplyFriday.size() == 1;
        assert needSupplyFriday.stream().anyMatch(c -> c instanceof Vezuvijus);
    }

    /**
     * 5. Uzduotis
     */
    @Test
    void getRevenuePerMonth() {
        throw new AssertionError();
    }

    /**
     * 5. Uzduotis
     */
    @Test
    void getNumberOrStudents() {
        throw new AssertionError();
    }

    /**
     * 5. Uzduotis
     */
    @Test
    void getAverageOrderPrice() {
        throw new AssertionError();
    }

    /**
     * 5. Uzduotis (period)
     */
    @Test
    void testGetAverageOrderPrice_history() {
        throw new AssertionError();
    }

    @Test
    void getAvailablePizzas() {
        assert pizzaShop.getAvailablePizzas().size() == 7;
    }

    private List<Pizza> getTestPizzas() { // value is 7 eur
        return List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));
    }
}
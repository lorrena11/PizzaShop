package pizza_shop;

import org.junit.jupiter.api.Test;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

class PizzaShopTest {

    private PizzaShop pizzaShop = new PizzaShop();

    @Test
    void getAverageOrderPrice() {
        pizzaShop.placeOrder(getTestPizzas());
        pizzaShop.placeOrder(getTestPizzas());
        assert pizzaShop.getAverageOrderPrice().equals(BigDecimal.valueOf(7));
    }

    @Test
    void testGetAverageOrderPrice_history() {
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 1, 20));
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 2, 10));
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 2, 25));
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2022, 2, 25));
        assert pizzaShop.getAverageOrderPrice(Month.FEBRUARY, Year.of(2021)).equals(BigDecimal.valueOf(7));
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
    }

    @Test
    void getPizzaThatNeedSupply() {
    }

    @Test
    void getRevenuePerMonth() {
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 1, 1));
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 1, 30));
        pizzaShop.placeHistoryOrder(getTestPizzas(), LocalDate.of(2021, 3, 1));
        assert pizzaShop.getRevenuePerMonth(Month.JANUARY, Year.of(2021)).equals(BigDecimal.valueOf(14));
    }

    @Test
    void getNumberOrStudents() {
        pizzaShop.placeOrder(getTestPizzas(), true, LocalDate.of(2021, 1, 30));
        pizzaShop.placeOrder(getTestPizzas(), true, LocalDate.of(2021, 1, 20));
        pizzaShop.placeOrder(getTestPizzas(), true, LocalDate.of(2021, 1, 10));
        pizzaShop.placeOrder(getTestPizzas(), true, LocalDate.of(2021, 2, 1));
        pizzaShop.placeOrder(getTestPizzas(), true, LocalDate.of(2021, 3, 1));
        pizzaShop.placeOrder(getTestPizzas(), false, LocalDate.of(2021, 3, 1));
        pizzaShop.placeOrder(getTestPizzas(), false, LocalDate.of(2021, 1, 1));
        pizzaShop.placeOrder(getTestPizzas(), false, LocalDate.of(2020, 1, 1));
        pizzaShop.placeOrder(getTestPizzas(), false, LocalDate.of(2020, 1, 22));
        assert pizzaShop.getNumberOfStudentsOrders(Month.JANUARY, Year.of(2021)) == 3;
    }

    @Test
    void getAvailablePizzas() {
        assert pizzaShop.getAvailablePizzas().size() == 7;
    }

    private List<Pizza> getTestPizzas() { // value is 7 eur
        return List.of(new Margarita(PizzaSize.SMALL), new Margarita(PizzaSize.MEDIUM));
    }
}
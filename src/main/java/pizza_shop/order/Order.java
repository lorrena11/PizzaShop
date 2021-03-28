package pizza_shop.order;

import pizza_shop.pizza.Pizza;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface Order {
    List<Pizza> getPizzaList();
    boolean isIsStudentDiscount();
    LocalDate getPurchaseDate();
    BigDecimal getTotalPrice();
}

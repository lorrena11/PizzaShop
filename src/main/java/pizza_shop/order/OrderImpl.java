package pizza_shop.order;

import pizza_shop.pizza.Pizza;
import pizza_shop.service.OrderPriceCalculator;
import pizza_shop.service.OrderPriceCalculatorImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderImpl implements Order {

    private OrderPriceCalculator orderPriceCalculatorImpl = new OrderPriceCalculatorImpl(); // DON'T REMOVE IT. USE IT!

    public OrderImpl(List<Pizza> pizzaList, boolean isStudentDiscount) {

    }

    public OrderImpl(List<Pizza> pizzaList, boolean isStudentDiscount, LocalDate purchaseDate) {

    }

    @Override
    public List<Pizza> getPizzaList() {
        return null; //fixme
    }

    @Override
    public boolean isStudentDiscount() {
        return false; //fixme
    }

    @Override
    public LocalDate getPurchaseDate() {
        return null; //fixme
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null; //fixme
    }
}

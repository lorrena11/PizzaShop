package pizza_shop.order;

import pizza_shop.pizza.Pizza;
import pizza_shop.service.OrderPriceCalculator;
import pizza_shop.service.OrderPriceCalculatorImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderImpl implements Order {

    private OrderPriceCalculator orderPriceCalculatorImpl = new OrderPriceCalculatorImpl(); // DON'T REMOVE IT. USE IT!
    private List<Pizza> pizzaList;
    private boolean isStudentDiscount;
    private LocalDate purchaseDate;

    public OrderImpl(List<Pizza> pizzaList, boolean isStudentDiscount) {
        this.pizzaList = pizzaList;
        this.isStudentDiscount = isStudentDiscount;
    }

    public OrderImpl(List<Pizza> pizzaList, boolean isStudentDiscount, LocalDate purchaseDate) {
        this.pizzaList = pizzaList;
        this.isStudentDiscount = isStudentDiscount;
        this.purchaseDate = purchaseDate;
    }

    @Override
    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    @Override
    public boolean isStudentDiscount() {
        return isStudentDiscount;
    }

    @Override
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return orderPriceCalculatorImpl.getOrderPrice(pizzaList, isStudentDiscount);
    }
}

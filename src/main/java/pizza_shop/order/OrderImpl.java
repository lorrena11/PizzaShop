package pizza_shop.order;

import pizza_shop.pizza.Pizza;
import pizza_shop.service.OrderPriceCalculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderImpl implements Order {

    private OrderPriceCalculator orderPriceCalculator = new OrderPriceCalculator();
    private List<Pizza> pizzaList;
    private boolean isStudentDiscount;
    private LocalDate purchaseDate;


    public OrderImpl(List<Pizza> pizzaList, boolean isStudentDiscount) {
        this.pizzaList = pizzaList;
        this.isStudentDiscount = isStudentDiscount;
        this.purchaseDate = LocalDate.now();
    }

    @Override
    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    @Override
    public boolean isIsStudentDiscount() {
        return isStudentDiscount;
    }

    @Override
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return orderPriceCalculator.getOrderPrice(pizzaList, isStudentDiscount);
    }
}

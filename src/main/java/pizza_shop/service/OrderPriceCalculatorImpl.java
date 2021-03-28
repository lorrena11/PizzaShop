package pizza_shop.service;

import pizza_shop.exception.EmptyOrderException;
import pizza_shop.order.Order;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaPriceComparator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service that is responsible for order price calculation
 */
public class OrderPriceCalculatorImpl implements OrderPriceCalculator {

    private static final BigDecimal STUDENT_DISCOUNT = BigDecimal.ONE;
    private static final int MIN_PIZZA_FOR_FREE = 4;

    @Override
    public BigDecimal getOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount) {
        if (pizzaList.isEmpty()) {
            throw new EmptyOrderException();
        }
        if (pizzaList.size() >= MIN_PIZZA_FOR_FREE) {
            return getFreePizzaOrderPrice(pizzaList, isStudentDiscount);
        }
        return getRegularOrderPrice(pizzaList, isStudentDiscount);
    }

    @Override
    public BigDecimal calculateAverageOrder(List<Order> orders) {
        return orders.stream()
                .map(Order::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(orders.size()), RoundingMode.HALF_DOWN);
    }

    @Override
    public BigDecimal calculateAverageOrderPeriod(List<Order> orders, Month month, Year year) {
        List<Order> filteredOrders = orders
                .stream()
                .filter(o -> isOrderGivenMonth(o, month, year))
                .collect(Collectors.toList());
        return calculateAverageOrder(filteredOrders);
    }

    @Override
    public boolean isOrderGivenMonth(Order o, Month month, Year year) {
        return o.getPurchaseDate().getMonth().equals(month)
                &&  Year.of(o.getPurchaseDate().getYear()).equals(year);
    }

    /**
     * Hint: use the comparator here.
     * @param pizzaList pizzas that were ordered
     * @param isStudentDiscount determines if the order was made by the student
     * @return total price of the order excluding cheapest pizza
     */
    private BigDecimal getFreePizzaOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount) {
        // cheapest pizza for free
        List<Pizza> pizzaWithoutCheapest = new ArrayList<>(pizzaList);
        pizzaWithoutCheapest.sort(new PizzaPriceComparator());
        pizzaWithoutCheapest.remove(pizzaWithoutCheapest.get(0));
        return getOrderPrice(pizzaWithoutCheapest, isStudentDiscount);
    }

    /**
     * @param pizzaList pizzas that were ordered
     * @param isStudentDiscount determines if the order was made by the student
     * @return total price of the order
     */
    private BigDecimal getRegularOrderPrice(List<Pizza> pizzaList, boolean isStudentDiscount) {
        return pizzaList.stream()
                .map(p -> calculateFinalPrice(p, isStudentDiscount))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Returns the price that needs to be paid by the customer. If customer has a student discount, we reduce the
     * price of the pizza by the amount that is declared as a student discount
     * @param pizza pizzas that were ordered
     * @param isStudentDiscount determines if the order was made by the student
     * @return final price of the pizze
     */
    private BigDecimal calculateFinalPrice(Pizza pizza, boolean isStudentDiscount) {
        BigDecimal regularPrice = pizza.getPrice();
        if (isStudentDiscount) {
            return regularPrice.subtract(STUDENT_DISCOUNT);
        }
        return regularPrice;
    }
}

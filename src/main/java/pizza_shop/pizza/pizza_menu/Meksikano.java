package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Meksikano extends Pizza {

    // every three days
    private LocalDate lastSupplyOrderMade = null;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(5);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(6);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(9);

    public Meksikano(PizzaSize pizzaSize) {
        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Meksikano() {
        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    @Override
    public boolean needsSupply(LocalDate serviceDate) {
        // returns true if given date is the date for service
        return serviceDate.equals(LocalDate.of(getDateOfService().getYear(), getDateOfService().getMonth(), getDateOfService().getDayOfMonth()));
    }

    @Override
    public boolean needsSupply() {
        return LocalDate.now().equals(getDateOfService());
    }

    private LocalDate getDateOfService() {
        if(lastSupplyOrderMade == null) {
            // service was never done, do it now
            supplyCompleted();
        }
        // last day of service + 3 days
        return lastSupplyOrderMade.plusDays(3);
    }

    private void supplyCompleted() {
        lastSupplyOrderMade = LocalDate.now();
    }
}
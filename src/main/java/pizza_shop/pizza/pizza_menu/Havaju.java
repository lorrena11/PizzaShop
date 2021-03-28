package pizza_shop.pizza.pizza_menu;

import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Havaju extends Pizza {

    // every two days
    private LocalDate lastSupplyOrderMade = null;

    private static final BigDecimal SMALL_PRICE = BigDecimal.valueOf(4.5);
    private static final BigDecimal MEDIUM_PRICE = BigDecimal.valueOf(5.5);
    private static final BigDecimal LARGE_PRICE = BigDecimal.valueOf(8.5);

    public Havaju(PizzaSize pizzaSize) {
        super(pizzaSize, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    public Havaju() {
        super(null, SMALL_PRICE, MEDIUM_PRICE, LARGE_PRICE);
    }

    @Override
    public boolean needsSupply(LocalDate serviceDate) {
        // returns true if given date is the date for supply
        return serviceDate.equals(LocalDate.of(getDateOfService().getYear(), getDateOfService().getMonth(), getDateOfService().getDayOfMonth()));
    }

    @Override
    public boolean needsSupply() {
        return LocalDate.now().equals(getDateOfService());
    }

    private LocalDate getDateOfService() {
        if(lastSupplyOrderMade == null) {
            // supply was never done, do it now
            supplyCompleted();
        }
        // last day of supply + 2 days
        return lastSupplyOrderMade.plusDays(2);
    }

    private void supplyCompleted() {
        lastSupplyOrderMade = LocalDate.now();
    }
}

package pizza_shop.pizza;

// DON'T Change anything in this file!

import java.time.LocalDate;

public interface SupplyIntervalCalculator {
    /**
     * Pizza needs to order supplies for given date
     *
     * @param date The date where supply is needed
     * @return true if this pizza needs to order supplies on the given date
     */
    boolean needsSupply(LocalDate date);

    /**
     * Needs supply today
     *
     * @return true if this pizza needs to order supplies today
     */
    boolean needsSupply();
}

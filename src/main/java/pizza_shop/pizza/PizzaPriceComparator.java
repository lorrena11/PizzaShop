package pizza_shop.pizza;

import java.util.Comparator;

/**
 * Price comparator of the pizza. DO NOT INCLUDE ANY OTHER METHODS OTHER THAN compare()!
 */
public class PizzaPriceComparator implements Comparator<Pizza> {
    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getPrice().intValue() - o2.getPrice().intValue();
    }
}

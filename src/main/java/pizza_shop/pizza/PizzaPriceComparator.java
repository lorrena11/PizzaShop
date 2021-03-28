package pizza_shop.pizza;

import java.util.Comparator;

public class PizzaPriceComparator implements Comparator<Pizza> {
    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}

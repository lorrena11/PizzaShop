import pizza_shop.order.Order;
import pizza_shop.order.OrderImpl;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Havaju;
import pizza_shop.pizza.pizza_menu.Margarita;
import pizza_shop.pizza.pizza_menu.Socioji;
import pizza_shop.pizza.pizza_menu.Vezuvijus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order1 = new OrderImpl(List.of(new Havaju(PizzaSize.SMALL), new Margarita(PizzaSize.SMALL), new Vezuvijus(PizzaSize.SMALL), new Socioji(PizzaSize.SMALL)), true);

        System.out.println(order1.getTotalPrice());
    }
}

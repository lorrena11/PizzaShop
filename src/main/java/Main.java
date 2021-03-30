import pizza_shop.PizzaShop;
import pizza_shop.pizza.Pizza;
import pizza_shop.pizza.PizzaSize;
import pizza_shop.pizza.pizza_menu.Margarita;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PizzaShop shop = new PizzaShop();
        // you can test your program here

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Margarita(PizzaSize.SMALL));
        pizzas.add(new Margarita(PizzaSize.MEDIUM));

        shop.placeOrder(pizzas, false);

        System.out.println("Order date:" + shop.getOrders().get(0).getPurchaseDate());
        System.out.println("Order contains :" + shop.getOrders().get(0).getPizzaList().size() + " pizzas! :o");
        System.out.println("Order price :" + shop.getOrders().get(0).getTotalPrice());

    }
}

import java.util.List;

public class DeliveryOrder implements OrderType {
	private Restaurants restaurant;
	private List<FoodI> order;
	public String name = "Delivery";

	public String getName() {
		return name;
	}

	public DeliveryOrder(Restaurants restaurant, List<FoodI> order) {
		this.restaurant = restaurant;
		this.order = order;
	}

	public Receipt placeOrder() {
		Receipt r = restaurant.sendOrder(order);
		System.out.println("Order will be delivered by " + r.deliveryTime);
		return r;
	}
}

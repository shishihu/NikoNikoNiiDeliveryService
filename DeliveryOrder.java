import java.util.List;

public class DeliveryOrder implements OrderType {
	private Restaurants restaurant;
	private List<Food> order;

	public DeliveryOrder(Restaurants restaurant, List<Food> order) {
		this.restaurant = restaurant;
		this.order = order;
	}

	public Receipt placeOrder() {
		Receipt r = restaurant.sendOrder(order);
		System.out.println("Order will be delivered by " + r.deliveryTime);
		return r;
	}
}

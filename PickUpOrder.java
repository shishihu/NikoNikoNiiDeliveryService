import java.util.List;

public class PickUpOrder implements OrderType {
	private Restaurants restaurant;
	private List<FoodI> order;

	public PickUpOrder(Restaurants restaurant, List<FoodI> order) {
		this.restaurant = restaurant;
		this.order = order;
	}

	public Receipt placeOrder() {
		Receipt r = restaurant.sendOrder(order);
		System.out.println("Order will be ready for pick up by " + r.deliveryTime);
		return r;
	}
}


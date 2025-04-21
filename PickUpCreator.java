import java.util.List;

public class PickUpCreator extends OrderFactory {
	public OrderType createOrder(Restaurants restaurant, List<FoodI> order) {
		return new PickUpOrder(restaurant, order);
	}
}

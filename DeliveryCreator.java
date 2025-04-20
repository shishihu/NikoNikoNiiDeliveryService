import java.util.List;

public class DeliveryCreator extends OrderFactory {
	public OrderType createOrder(Restaurants restaurant, List<Food> order) {
		return new DeliveryOrder(restaurant, order);
	}
}

import java.util.List;

public abstract class OrderFactory {
	abstract OrderType createOrder(Restaurants restaurant, List<Food> order);

	public OrderType prepareOrder(Restaurants restaurant, List<Food> order) {
		return createOrder(restaurant, order);
	}
}


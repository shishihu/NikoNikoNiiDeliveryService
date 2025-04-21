import java.util.List;

public abstract class OrderFactory {
	abstract OrderType createOrder(Restaurants restaurant, List<FoodI> order);

	public OrderType prepareOrder(Restaurants restaurant, List<FoodI> order) {
		return createOrder(restaurant, order);
	}
}


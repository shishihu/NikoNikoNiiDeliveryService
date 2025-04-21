import java.util.List;
import java.util.ArrayList;

public class RestaurantHandler extends ChainHandler {
	// This shouldn't ever be called
	public List<Restaurants> getRestaurants() {
		return next.getRestaurants();
	}

	public List<FoodI> getMenu(Restaurants restaurant) {
		return restaurant.getMenuItems();
	}

	public Receipt sendOrder(OrderType orderType) {
		return orderType.placeOrder();
	}
}

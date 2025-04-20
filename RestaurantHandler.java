import java.util.List;
import java.util.ArrayList;

public class RestaurantHandler extend ChainHandler {
	// This shouldn't ever be called
	public List<Restaurants> getRestaurants() {
		return next.getRestaurants();
	}

	public List<Food> getMenu(Restaurants restaurant) {
		return restaurant.getMenuItems();
	}

	public Receipt sendOrder(Restaurants restaurant, List<Food> order) {
		return restaurant.sendOrder(order);
	}
}

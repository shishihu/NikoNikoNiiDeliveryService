import java.util.List;
import java.util.ArrayList;

public class ClientHandler extends ChainHandler {
	public List<Restaurants> getRestaurants() {
		return next.getRestaurants();
	}

	public List<Food> getMenu(Restaurants restaurant) {
		return next.getMenu(restaurant);
	}

	public Receipt sendOrder(Restaurants restaurant, List<Food> order) {
		return next.sendOrder(restaurant, order);
	}
}


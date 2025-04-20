import java.util.List;
import java.util.ArrayList;

public class ServerHandler extends ChainHandler {
	public List<Restaurants> getRestaurants() {
		return Server.getRestaurants();
	}

	public List<Food> getMenu(Restaurants restaurant) {
		return next.getMenu(restaurant);
	}

	public Receipt sendOrder(Restaurants restaurant, List<Food> order) {
		return next.sendOrder(restaurant, order);
	}
}

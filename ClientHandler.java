import java.util.List;
import java.util.ArrayList;

public class ClientHandler extends ChainHandler {
	public List<Restaurants> getRestaurants() {
		return next.getRestaurants();
	}

	public List<FoodI> getMenu(Restaurants restaurant) {
		return next.getMenu(restaurant);
	}

	public Receipt sendOrder(OrderType orderType) {
		return next.sendOrder(orderType);
	}
}


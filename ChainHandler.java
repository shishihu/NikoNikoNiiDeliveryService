import java.util.List;
import java.util.ArrayList;

public abstract class ChainHandler {
	ChainHandler next;

	public void setNext(ChainHandler n) {
		this.next = n;
	}

	// Get restaurants
	public abstract List<Restaurants> getRestaurants();

	// Get menu from restaurant
	public abstract List<FoodI> getMenu(Restaurants restaurant);

	// Send order to restaurant
	public abstract Receipt sendOrder(OrderType orderType);

}

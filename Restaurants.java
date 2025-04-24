import java.util.List;
import java.util.Arrays;

public class Restaurants implements NamedObject{
    protected String cuisine = null;
	protected String name = null;

	int cost;

	protected List<FoodI> menu = Arrays.asList(new Food("place holder", 0));

	public String getName() {
		return name;
	}


    public List<FoodI> getMenuItems(){
		return this.menu;
    }

    String getCuisine(){
        return cuisine;
    }

	Receipt sendOrder(List<FoodI> order) {
		Receipt receipt = new Receipt(0, 30);

		for (FoodI item : order) {

			receipt.cost += item.getCost();
		}
		return receipt;
	}
}



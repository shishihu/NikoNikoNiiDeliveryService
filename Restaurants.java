import java.util.List;

public class Restaurants implements NamedObject{
    protected String cuisine = null;
	protected String name = null;

	public String getName() {
		return name;
	}

    int getCost(){
        return 0;
    }

    public List<Food> getMenuItems(){
        return List.of(new Food("Place holder", 0));
    }

    String getCuisine(){
        return cuisine;
    }

	Receipt sendOrder(List<Food> order) {
		Receipt receipt = new Receipt(0, 30);
		for (Food item : order) {
			receipt.cost += item.cost;
		}
		return receipt;
	}
}



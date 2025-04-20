import java.util.List;

public class Restaurants{
    protected String cuisine = null;
    int getCost(){
        return 0;
    }
    public List<String> getMenuItems(){
        return List.of("");
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



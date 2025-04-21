import java.util.Arrays;
import java.util.List;

public class TheGoldenWhisk extends Restaurants {
    String cuisine = "Chinese";

	public TheGoldenWhisk() {
		name = "The Golden Whisk";
		menu = Arrays.asList(
			new Food("Lo Mein", 5)
		);
	}

    // private List<String> menu = Arrays.asList("Spring Rolls", "Dumplings", "Crab Rangoon",
    //        "Sweet and Sour Chicken", "Kung Pao Pork", "Beef with Broccoli", "General Tso's Chicken");

    private List<Double> costs = Arrays.asList(5.0, 10.0, 3.0, 5.0, 6.0, 7.0, 5.0);

    private void addItemCost(List<String> addedItems){
        for (String addedItem : addedItems) {
            this.cost += costs.get(menu.indexOf(addedItem));
        }
    }

    @Override
    public String getCuisine(){
        return "Chinese";
    }
}

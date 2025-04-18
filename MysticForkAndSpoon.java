import java.util.Arrays;
import java.util.List;

public class MysticForkAndSpoon extends Restaurants {

    private List<String> menu = Arrays.asList("Basil and Herb Mushrooms", "Garlic Bread", "Tomato Basil Soup");
    private List<Double> costs = Arrays.asList(13.0, 3.0, 6.0);

    private int cost = 0;

    private void addItemCost(List<String> addedItems){
        for (String addedItem : addedItems) {
            this.cost += costs.get(menu.indexOf(addedItem));
        }
    }
    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public List<String> getMenuItems() {
        return menu;
    }
}

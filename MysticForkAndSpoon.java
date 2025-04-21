import java.util.Arrays;
import java.util.List;

public class MysticForkAndSpoon extends Restaurants {

    // private List<String> menu = Arrays.asList("Basil and Herb Mushrooms", "Garlic Bread", "Tomato Basil Soup");

    private List<Double> costs = Arrays.asList(13.0, 3.0, 6.0);


	public MysticForkAndSpoon() {
		name = "Mystic Fork and Spoon";
		menu = Arrays.asList(
			new Food("Buger", 15)
		);
	}
}

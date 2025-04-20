import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Server {
	static Restaurants[] knownRestaurants = new Restaurants[] {new MysticForkAndSpoon()};

	public static List<Restaurants> getRestaurants() {
		return Arrays.asList(knownRestaurants);
	}
}


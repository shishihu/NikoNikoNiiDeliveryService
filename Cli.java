import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Cli {
	private static ChainHandler clientHandler;

	public static void main(String[] args) {
		createChainOfCommand();
		Scanner in = new Scanner(System.in);

		List<Restaurants> restaurants = clientHandler.getRestaurants();
		System.out.println("Select a restaurant: ");
		int restaurantIndex = makeSelection(restaurants, in);
		Restaurants chosenResaurant = restaurants.get(restaurantIndex);

		List<Food> menu = clientHandler.getMenu(chosenResaurant);
		System.out.println("Select a menu item: ");
		int menuIndex = makeSelection(menu, in);
		Food chosenOrder = menu.get(menuIndex);

		in.close();
	}

	private static int makeSelection(List<? extends NamedObject> list, Scanner in) {
		List<String> names = new ArrayList<String>();
		for (NamedObject o : list) {
			names.add(o.getName());
		}

		for (int i = 0; i < names.size(); i++) {
			// This uses ANSII color codes
			// Set number bold, then reset
			System.out.println("\t\033[1;37m" + (i + 1) + ":\033[0m " + names.get(i));
		}

		int index = -1;
		while (index == -1) {
			String selection = in.nextLine();
			try {
				index = Integer.valueOf(selection) - 1;
				if (index < 0 || index >= list.size()) {
					System.out.println("Invalid selection. Try again.");
					index = -1;
				}
			} catch (NumberFormatException e) {
				System.out.println("Just enter the number. Try again.");
			}
		}
		System.out.println("User selected " + names.get(index));
		return index;
	}

	private static void createChainOfCommand() {
		clientHandler = new ClientHandler();
		ChainHandler serverHandler = new ServerHandler();
		ChainHandler restaurantHandler = new RestaurantHandler();

		clientHandler.setNext(serverHandler);
		serverHandler.setNext(restaurantHandler);
	}

	private static List<String> getCuisines() {
		List<String> c = Arrays.asList("joe", "biden", "niko", "nii");
		return c;
	}

	private static List<String> getRestaurants(String cuisine) {
		List<String> restaurants = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			restaurants.add(Integer.toString(i));
		}
		return restaurants;
	}
}

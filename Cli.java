import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Cli {
	private static ChainHandler clientHandler;

	public static void main(String[] args) {
		clientHandler = new ClientHandler();
		ChainHandler serverHandler = new ServerHandler();
		ChainHandler restaurantHandler = new RestaurantHandler();

		clientHandler.setNext(serverHandler);
		serverHandler.setNext(restaurantHandler);

		Scanner in = new Scanner(System.in);

		List<Restaurants> restaurants = clientHandler.getRestaurants();
		List<String> restaurantNames = new ArrayList<String>();
		for (Restaurants r : restaurants) {
			restaurantNames.add(r.getName());
		}
		System.out.println("Select a restaurant: ");
		int restaurantIndex = makeSelection(restaurantNames, in);
		System.out.println("User selected " + restaurantNames.get(restaurantIndex));

		in.close();
	}

	private static int makeSelection(List<String> list, Scanner in) {
		for (int i = 0; i < list.size(); i++) {
			// This uses ANSII color codes
			// Set number bold, then reset
			System.out.println("\t\033[1;37m" + (i + 1) + ":\033[0m " + list.get(i));
		}

		int index = 0;
		while (index == 0) {
			String selection = in.nextLine();
			try {
				index = Integer.valueOf(selection) - 1;
				if (index < 0 || index >= list.size()) {
					System.out.println("Invalid selection. Try again.");
					index = 0;
				}
			} catch (NumberFormatException e) {
				System.out.println("Just enter the number. Try again.");
			}
		}
		return index;
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

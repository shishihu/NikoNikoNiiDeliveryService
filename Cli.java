import java.util.Scanner;

class Cli {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Select a cuisine: ");
		String[] cuisines = getCuisines();
		int cuisineIndex = makeSelection(cuisines, in);
		System.out.println("User selected " + cuisines[cuisineIndex]);

		String[] restaurants = getRestaurants(cuisines[cuisineIndex]);
		System.out.println("Select a restaurant: ");
		int restaurantIndex = makeSelection(restaurants, in);
		System.out.println("User selected " + restaurants[restaurantIndex]);

		in.close();
	}

	private static int makeSelection(String[] list, Scanner in) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + 1 + ": " + list[i]);
		}

		int index = 0;
		while (index == 0) {
			String selection = in.nextLine();
			try {
				index = Integer.valueOf(selection) - 1;
				if (index < 0 || index >= list.length) {
					System.out.println("Invalid selection. Try again.");
					index = 0;
				}
			} catch (NumberFormatException e) {
				System.out.println("Just enter the number. Try again.");
			}
		}
		return index;
	}

	private static String[] getCuisines() {
		return new String[]{"joe", "biden", "niko", "ni"};
	}

	private static String[] getRestaurants(String cuisine) {
		String[] restaurants = new String[10];
		for (int i = 0; i < restaurants.length; i++) {
			restaurants[i] = Integer.toString(i);
		}
		return restaurants;
	}
}

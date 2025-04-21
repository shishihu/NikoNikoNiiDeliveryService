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


		List<FoodI> menu = clientHandler.getMenu(chosenResaurant);
		List<FoodI> chosenOrderList = new ArrayList<FoodI>();

		List<FoodI> interactiveMenu = new ArrayList<FoodI>(menu);
		FoodI exit_condition = new Food("Enter 1 to stop adding items to order", 0);
		interactiveMenu.add(0, exit_condition);

		boolean moreItemsToOrder = true;
		while (moreItemsToOrder) {
			System.out.println("Select a menu item: ");
			int menuIndex = makeSelection(interactiveMenu, in);
			if (menuIndex == 0) {
				break;
			}
			FoodI chosenOrder = interactiveMenu.get(menuIndex);
			FoodI customOrder = customizeOrder(in, chosenOrder);
			chosenOrderList.add(customOrder);
		}

		System.out.println("Final order: ");
		List<String> orderNames = new ArrayList<String>();
		for (NamedObject o : chosenOrderList) {
			orderNames.add(o.getName());
		}
		prettyPrintList(orderNames);
		System.out.println();

		OrderType orderType = chooseOrderType(in, chosenResaurant, chosenOrderList);
		clientHandler.sendOrder(orderType);

		in.close();
	}

	private static FoodI customizeOrder(Scanner in, FoodI item){
		FoodI finalItem;
        System.out.println("Would you like to customize your dish?");
        String yesOrNo = in.nextLine();
        if (yesOrNo.charAt(0) == 'y') {
            System.out.println("What customizations would you like?");
            String customization = in.nextLine();
			FoodCustomization decorator = new FoodCustomization(item);
			decorator.modify(customization, 1);
			finalItem = decorator;
        }
		else {
			finalItem = item;
		}
        System.out.println("You have ordered " + finalItem.getName());
		System.out.println();
		return finalItem;
    }

	private static OrderType chooseOrderType(Scanner in, Restaurants restaurant, List<FoodI> order) {
		System.out.println("Select an order type: ");
		List<String> names = Arrays.asList("Delivery", "Pick Up");
		int index = makeNamedSelection(names, in);
		if (index == 0) {
			return new DeliveryCreator().createOrder(restaurant, order);
		}
		else {
			return new PickUpCreator().createOrder(restaurant, order);
		}
	}

	private static void prettyPrintList(List<String> names) {
		for (int i = 0; i < names.size(); i++) {
			// This uses ANSII color codes
			// Set number bold, then reset
			System.out.println("\t\033[1;37m" + (i + 1) + ":\033[0m " + names.get(i));
		}
	}

	private static int makeNamedSelection(List<String> names, Scanner in) {
		prettyPrintList(names);
		int sentinelValue = names.size() + 1;
		int index = sentinelValue;
		while (index == sentinelValue) {
			String selection = in.nextLine();
			try {
				index = Integer.valueOf(selection) - 1;
				if (index < 0 || index >= names.size()) {
					System.out.println("Invalid selection. Try again.");
					index = sentinelValue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Just enter the number. Try again.");
			}
		}
		System.out.println("User selected " + names.get(index));
		System.out.println();
		return index;
	}

	private static int makeSelection(List<? extends NamedObject> list, Scanner in) {
		List<String> names = new ArrayList<String>();
		for (NamedObject o : list) {
			names.add(o.getName());
		}
		return makeNamedSelection(names, in);
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

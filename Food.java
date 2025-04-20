public class Food implements NamedObject {
	int cost;
	private String name;

	public String getName() {
		return name;
	}

	public Food(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
}

import java.util.Scanner;

public class FoodCustomization implements FoodI{
	private String nameAddOn;
	private int extraCost;
	private FoodI wrappee;

	public FoodCustomization(FoodI item) {
		this.wrappee = item;
		this.nameAddOn = "";
		this.extraCost = 0;
	}

    public void modify(String customizations, int extraCost) {
		this.nameAddOn = " + " + customizations;
		this.extraCost = extraCost;
    }

	@Override
	public String getName() {
		return wrappee.getName() + nameAddOn;
	}

	@Override
	public int getCost() {
		return wrappee.getCost() + extraCost;
	}

	public void setName(String name) {
		wrappee.setName(name);
	}
}

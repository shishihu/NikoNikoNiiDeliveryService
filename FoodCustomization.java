import java.util.Scanner;

public class FoodCustomization extends Food{
    public FoodCustomization(String name, int cost){
        super(name, cost);
        Scanner sf = new Scanner(System.in);
        System.out.println("Would you like to customize your dish?");
        String yesOrNo = sf.nextLine();
        if (yesOrNo.charAt(0) == 'y') {
            System.out.println("What customizations would you like?");
            String cs = sf.nextLine();
            String newName = getItemWithCustomizations(cs);
            setName(newName);
        }
        System.out.println("You have ordered " + getName());
    }
    public String getItemWithCustomizations(String customizations){
        return getName() + " with " + customizations;
    }
}

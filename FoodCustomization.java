import java.util.Scanner;

public class FoodCustomization extends Food{
    public FoodCustomization(){
        String customizations = "";
        System.out.println("Would you like to customize your dish?");
        Scanner sf = new Scanner(System.in);
        String yesOrNo = sf.nextLine();
        if (yesOrNo.charAt(0) == 'y'){
            System.out.println("What customizations would you like?");
        } else if (yesOrNo.charAt(0) == 'n'){

        }
        else{

        }
    }
}

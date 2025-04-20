public class Food implements NamedObject {
    private int cost;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCost() {
        return cost;
    }
    public Food(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
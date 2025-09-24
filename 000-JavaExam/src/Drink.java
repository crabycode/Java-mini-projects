public class Drink {
    private int drinkId;
    private String name;
    private String type;
    private int quantity;

    public Drink(int drinkId, String name, String type, int quantity) {
        this.drinkId = drinkId;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }
    public int getId() {
        return drinkId;
    }

    public void setId(int id) {
        this.drinkId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

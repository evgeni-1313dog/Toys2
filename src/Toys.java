public class Toys {
    private String id;
    private String name;
    private String quantity;

    public String getId() {
        return String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



    public Toys( String name, String quantity) {

        this.name = name;
        this.quantity = quantity;
    }
public Toys(String id, String name, String quantity){
        this.id = id;
}
    @Override
    public String toString() {
        return String.format("%d, %s, %d", id, name, quantity);
    }
}

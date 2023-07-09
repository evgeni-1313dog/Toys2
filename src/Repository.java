import java.util.List;

public interface Repository {
    List<Toys> getAllToy();
    String CreateToys(Toys toys);

    void updateToys(Toys toys);

    void setUpdatedToys(Toys updatedToys);

    void deleteToys(String id);


}
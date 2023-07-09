import java.util.List;

public class ToysController {
    private final Repository repository;

    public ToysController(Repository repository) {
        this.repository = repository;
    }

    public void saveToys(Toys toys) {
        repository.CreateToys(toys);
    }

    public Toys readToys(String toysId) throws Exception {
        List<Toys> toy = repository.getAllToy();
        for (Toys toys : toy) {
            if (toys.getId().equals(toysId)) {
                return toys;
            }
        }

        throw new Exception("User not found");
    }

    public List<Toys> getToy(){
        return repository.getAllToy();
    }

    public void updateToys(Toys updatedToys) {
        repository.updateToys(updatedToys);
    }


    public void deleteToys(String userId) {
        repository.deleteToys(userId);
    }



}
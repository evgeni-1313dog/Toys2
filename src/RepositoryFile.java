import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private ToysMapper mapper = new ToysMapper();
    private FileOperation fileOperation;
    private List<Toys> toy;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Toys> getAllToy() {
        List<String> lines = fileOperation.readAllLines();
        List<Toys> toy = new ArrayList<>();
        for (String line : lines) {
            toy.add(mapper.map(line));
        }
        return toy;
    }

    @Override
    public String CreateToys(Toys toys) {

        List<Toys> toy = getAllToy();
        int max = 0;
        for (Toys item : toy) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        toys.setId(id);
        toy.add(toys);
        saveAllToys(toy);
        return id;
    }

    @Override
    public void updateToys(Toys toys) {

    }


    @Override
    public void setUpdatedToys(Toys updatedToys) {
        List<Toys> toy = this.getAllToy();
        for (Toys toys : toy) {
            if(toys.getId().equals(updatedToys.getId())){
                toys.setName(updatedToys.getName());
                toys.setQuantity(updatedToys.getQuantity());

            }
        }
        saveAllToys(toy);
    }



    @Override
    public void deleteToys(String id) {

        for(Toys toys: toy){
            if (toys.getId().equals(id)) {
                toy.remove(toys);
            }
            saveAllToys(toy);
        }
    }



    private void saveAllToys(List<Toys> toy){
        List<String> lines = new ArrayList<>();
        for (Toys item: toy) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);

    }


}


public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("toys.txt");
        Repository repository = new RepositoryFile(fileOperation);
        ToysController controller = new ToysController(repository);
        ViewToys view = new ViewToys(controller);
        view.run();
    }
}
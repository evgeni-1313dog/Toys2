import java.util.List;
import java.util.Scanner;

public class ViewToys {

    private ToysController toysController;

    public ViewToys(ToysController toysController) {
        this.toysController = toysController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        createToys();
                        break;
                    case READ:
                        readToys();
                        break;
                    case LIST:
                        printAllToy();
                        break;
                    case UPDATE:
                        updateToys();
                        break;
                    case DELETE:
                        deleteToy();

                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



    private void deleteToy() throws Exception {
        String toysId = readToys();
        toysController.deleteToys(toysId);
    }

    private void createToys() {
        toysController.saveToys(inputToys());
    }
    private Toys inputToys(){
        String name;
        String quantity;
        name = prompt("Название игрушки: ");
        quantity = prompt("Количество: ");

                return  new Toys (name, quantity );
    }
    private String readToys() {
        String id = prompt("Идентификатор игрушки: ");
        try {
            Toys toys = toysController.readToys(id);
            System.out.println(toys);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    private void updateToys() {
        String id = readToys();
        Toys updatedToys = inputToys();
        updatedToys.setId(id);
        toysController.updateToys(updatedToys);
    }

    private void printAllToy() {
        List<Toys> toy = toysController.getToy();
        for (Toys toys : toy) {
            System.out.println(toy);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
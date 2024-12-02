public class Mainn {
    public static void main(String[] args) {
        // Create the model, view, and controller
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Set the data and update the view
        controller.setData("Hello,Code with Hashir Hamid!"); // Update the Model's data.
        controller.updateView(); // Display the updated data via the View.
    }
}

class Model {
    private String data; // Stores data in the Model.

    // Getter for data.
    public String getData() {
        return data;
    }

    // Setter for data.
    public void setData(String data) {
        this.data = data;
    }
}

class Controller {
    private Model model; // Connects to the Model.
    private View view; // Connects to the View.

    // Constructor to initialize the Model and View.
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // Method to update the data in the Model.
    public void setData(String data) {
        model.setData(data);
    }

    // Method to retrieve data from the Model.
    public String getData() {
        return model.getData();
    }

    public void updateView() {
        view.printData(model.getData());
    }
}

class View {
    public void printData(String data) {
        System.out.println("Data: " + data);
    }
}
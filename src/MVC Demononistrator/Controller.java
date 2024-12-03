
public class Controller {

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

    // Method to refresh the View with updated data from the Model.
    public void updateView() {
        view.printData(model.getData());
    }
}

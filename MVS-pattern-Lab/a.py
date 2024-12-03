import tkinter as tk

# Model class to manage the count
class Model:
    def __init__(self):
        self.count = 0 
    
    # Increment the count
    def increment(self):
        self.count += 1
    
    
    def reset(self):
        self.count = 0
    
    def get_count(self):
        return self.count

# View class to manage the UI
class View:
    def __init__(self, master):
        self.master = master
        self.master.title("MVC Counter App")

       
        self.counter = tk.Label(self.master, text="0", font=("Arial", 30))
        self.counter.pack()

        self.increment_button = tk.Button(self.master, text="Increment", font=("Arial", 14))
        self.increment_button.pack(pady=10)

        self.reset_button = tk.Button(self.master, text="Reset", font=("Arial", 14))
        self.reset_button.pack(pady=10)
    
    def update_counter(self, value):
        self.counter.config(text=str(value))

    def bind_increment(self, handler):
        self.increment_button.config(command=handler)

    def bind_reset(self, handler):
        self.reset_button.config(command=handler)

# Controller class to handle the logic between Model and View
class Controller:
    def __init__(self, model, view):
        self.model = model
        self.view = view

        self.view.bind_increment(self.handle_increment)
        self.view.bind_reset(self.handle_reset)

        self.view.update_counter(self.model.get_count())

    def handle_increment(self):
        self.model.increment()  # Update the model
        self.view.update_counter(self.model.get_count())  # Update the view

    def handle_reset(self):
        self.model.reset()  # Reset the model
        self.view.update_counter(self.model.get_count())  # Update the view

# Initialize the app with the model, view, and controller
root = tk.Tk()
view = View(root)
model = Model()
controller = Controller(model, view)

# Start the main Tkinter loop
root.mainloop()

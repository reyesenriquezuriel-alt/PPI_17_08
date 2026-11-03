public class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(StudentView view) {
        this.view = view;
    }

    // Coordinates the registration process
    public void registerStudent() {

        String id = view.readId();
        String name = view.readName();
        String major = view.readMajor();

        // Creates/updates the Model using the supplied data
        model = new Student(id, name, major);

        view.showMessage("\nStudent registered successfully.");

        // Sends the Model information to the View
        view.displayStudent(model);
    }
}
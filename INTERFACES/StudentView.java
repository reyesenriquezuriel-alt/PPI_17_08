import java.util.Scanner;

public class StudentView {

    private final Scanner scanner = new Scanner(System.in);

    public String readId() {
        System.out.print("Enter student ID: ");
        return scanner.nextLine();
    }
    public String readName() {
        System.out.print("Enter student name: ");
        return scanner.nextLine();
    }
    public String readMajor() {
        System.out.print("Enter student major: ");
        return scanner.nextLine();
    }
    public void displayStudent(Student student) {
        System.out.println("\n--- Registered Student ---");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Major: " + student.getMajor());
    }
    public void showMessage(String message) {
        System.out.println(message);
    }
}
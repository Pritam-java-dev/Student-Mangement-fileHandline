import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentManager manager = new StudentManager();

            // Load data from file
            manager.loadFromFile();

            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character
                        System.out.print("Enter student grade: ");
                        String grade = scanner.nextLine();
                        manager.addStudent(new Student(name, rollNumber, grade));
                        break;
                    case 2:
                        manager.displayStudents();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}

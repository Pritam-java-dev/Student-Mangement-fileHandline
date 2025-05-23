import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor and Getter/Setters
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Add a student to the list
    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    // Save students list to file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Load students from file
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");
                String name = details[0].split(": ")[1];
                int rollNumber = Integer.parseInt(details[1].split(": ")[1]);
                String grade = details[2].split(": ")[1];
                students.add(new Student(name, rollNumber, grade));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }

    // Display all students
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}


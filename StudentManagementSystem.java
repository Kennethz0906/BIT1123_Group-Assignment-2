import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private Scanner scanner;
    
    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeSampleData();
    }
    
    // Initialize some sample courses
    private void initializeSampleData() {
        courses.add(new Course("BIT1123", "Object Oriented Programming", 3, 
                               "Sir Nazmirul", 2000.00));
        courses.add(new Course("BIT1083", "Data Structure", 3, 
                               "Ms. Safia", 1460.00));
        courses.add(new Course("BIT1053", "Computer Programming", 3, 
                               "Dr. Inam Ullah", 1000.00));
        courses.add(new Course("BIT4253", "Penetration Testing", 3, 
                                "Dr. Khairul Amin", 1750.00));   
        courses.add(new Course("MPU3193", "Philosophy & Current Issues", 3, 
                                "Sir Ahmad", 1500.00));                                           
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.displayMenu();
    }

    // Main menu
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n   STUDENT MANAGEMENT SYSTEM     ");
            System.out.println("=================================");
            System.out.println("1. Add New Student               ");
            System.out.println("2. Display All Students          ");
            System.out.println("3. Search Student by ID          ");
            System.out.println("4. Register Course for Student   ");
            System.out.println("5. Display Available Courses     ");
            System.out.println("6. Update Student CGPA           ");
            System.out.println("7. Exit                          \n");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch(choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    registerCourse();
                    break;
                case 5:
                    displayAllCourses();
                    break;
                case 6:
                    updateStudentCGPA();
                    break;
                case 7:
                    System.out.println("Thank you for using the system! \nSee you again!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(choice != 7);
    }
    
    // Method to add new student
    private void addNewStudent() {
        System.out.println("\n--- ADD NEW STUDENT ---");
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();
        
        System.out.print("Enter Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();
        
        Student student = new Student(name, age, id, email, program, semester);
        students.add(student);
        
        System.out.println("Student added successfully!");
    }
    
    // Method to display all students
    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students in the system.");
            return;
        }
        
        System.out.println("\n=== ALL STUDENTS ===");
        for (Student student : students) {
            student.displayInfo();
        }
    }
    
    // Method to search for a student
    private void searchStudent() {
        System.out.print("\nEnter Student ID to search: ");
        String searchId = scanner.nextLine();
        
        for (Student student : students) {
            if (student.getId().equals(searchId)) {
                student.displayInfo();
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    // Method to register course for student
    private void registerCourse() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        
        // Find student
        Student foundStudent = null;
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                foundStudent = student;
                break;
            }
        }
        
        if (foundStudent == null) {
            System.out.println("Student not found!");
            return;
        }
        
        // Display available courses
        displayAllCourses();
        
        System.out.print("Enter Course Code to register: ");
        String courseCode = scanner.nextLine();
        
        // Find course
        Course foundCourse = null;
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                foundCourse = course;
                break;
            }
        }
        
        if (foundCourse == null) {
            System.out.println("Course not found!");
            return;
        }
        
        // Register course
        foundStudent.registerCourse(foundCourse);
    }
    
    
    // Method to display all courses
    private void displayAllCourses() {
        System.out.println("\n=== AVAILABLE COURSES ===");
        for (Course course : courses) {
            course.displayCourseInfo();
        }
    }
    
    // Method to update student CGPA
    private void updateStudentCGPA() {
        System.out.print("\nEnter Student ID: ");
        String studentId = scanner.nextLine();
        
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.print("Enter new CGPA (0.0 - 4.0): ");
                double newCgpa = scanner.nextDouble();
                scanner.nextLine();
                student.setCgpa(newCgpa);
                System.out.println("CGPA updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
}

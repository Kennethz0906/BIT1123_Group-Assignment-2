public class Student extends person {

    private String program;
    private int semester;
    private double cgpa;
    private Course[] registeredCourses;
    private int courseCount;
    
    // Constructor
    public Student(String name, int age, String id, String email, String program, int semester) {
        super(name, age, id, email); // Call parent constructor
        this.program = program;
        this.semester = semester;
        this.cgpa = 0.0;
        this.registeredCourses = new Course[6]; // Max 6 courses
        this.courseCount = 0;
    }
    
    // Getters and Setters
    public String getProgram() {
        return program;
    }
    
    public void setProgram(String program) {
        this.program = program;
    }
    
    public int getSemester() {
        return semester;
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public double getCgpa() {
        return cgpa;
    }
    
    public void setCgpa(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 4.0) {
            this.cgpa = cgpa;
        } else {
            System.out.println("Invalid CGPA! Must be between 0.0 and 4.0");
        }
    }
    
    // Method to register for a course
    public void registerCourse(Course course) {
        if (courseCount < registeredCourses.length) {
            registeredCourses[courseCount] = course;
            courseCount++;
            System.out.println("Course " + course.getCourseName() + " registered successfully!");
        } else {
            System.out.println("Cannot register more than 10 courses!");
        }
    }
    
    // Method to display registered courses
    public void displayRegisteredCourses() {
        if (courseCount == 0) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("\n--- Registered Courses ---");
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + registeredCourses[i].getCourseName() + 
                                 " (" + registeredCourses[i].getCourseCode() + ")");
            }
        }
    }
    
    // POLYMORPHISM - Method Overriding
    @Override
    public void displayInfo() {
        System.out.println("\n=== STUDENT INFORMATION ===");
        displayBasicInfo(); // Call parent method
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
        displayRegisteredCourses();
        System.out.println("===========================");
    }
}



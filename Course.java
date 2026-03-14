public class Course {
    // Encapsulated attributes
    private String courseCode;
    private String courseName;
    private int creditHours;
    private String lecturer;
    private double fee;
    
    // Constructor
    public Course(String courseCode, String courseName, int creditHours, 
                  String lecturer, double fee) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.lecturer = lecturer;
        this.fee = fee;
    }
    
    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getCreditHours() {
        return creditHours;
    }
    
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
    
    public String getLecturer() {
        return lecturer;
    }
    
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
    
    public double getFee() {
        return fee;
    }
    
    public void setFee(double fee) {
        this.fee = fee;
    }
    
    // Display course information
    public void displayCourseInfo() {
        System.out.println("\n--- Course Information ---");
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Lecturer: " + lecturer);
        System.out.println("Fee: RM " + fee);
        System.out.println("--------------------------");
    }
}

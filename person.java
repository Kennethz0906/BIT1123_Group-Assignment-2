public abstract class person {
    private String name;
    private int age;
    private String id; 
    private String email;

    // Constructor
    public person(String name, int age, String id, String email) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.email = email;
    }

    //Getter and Setter methods 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    } 

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Abstract method 
    public abstract void displayInfo();

    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
    }
}
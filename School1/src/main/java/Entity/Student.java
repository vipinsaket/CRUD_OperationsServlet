package Entity;

public class Student {
	
	private int id;
    private String name;
    private int age;
    private String gender;
    private String dob;
    private String email;
    private String mobile;
    private String address;
    private String studentClass;
    
    // Updated constructor
    public Student(int id, String name, int age, String gender, String dob,
                  String email, String mobile, String address, String studentClass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.studentClass = studentClass;
    }
    
    // Getters for all fields
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDob() { return dob; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getAddress() { return address; }
    public String getStudentClass() { return studentClass; }
}

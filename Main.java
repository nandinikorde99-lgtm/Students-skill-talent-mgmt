package module2_profile_management;

abstract class Profile {
    private String studentId;
    public Profile(String studentId) { this.studentId = studentId; }
    public String getStudentId() { return studentId; }
    public abstract void display();
}

class Student {
    private String name;
    private Profile profile;
    public Student(String name, Profile profile) { this.name=name; this.profile=profile; }
    public void showProfile() { System.out.println("Student: " + name); profile.display(); }
}

class AcademicDetails extends Profile {
    private String course;
    public AcademicDetails(String id, String course) { super(id); this.course=course; }
    @Override public void display() { System.out.println("Course: " + course); }
}

class ContactDetails extends Profile {
    private String phone;
    public ContactDetails(String id, String phone) { super(id); this.phone=phone; }
    @Override public void display() { System.out.println("Phone: " + phone); }
}

class ProfileManager {
    public void updateProfile(Profile profile) {
        System.out.println("Profile updated for: " + profile.getStudentId());
    }
}

public class Main {
    public static void main(String[] args) {
        Profile academic = new AcademicDetails("BT250123DS", "Data Science");
        Student s = new Student("Huzeifa", academic);
        s.showProfile();
        new ProfileManager().updateProfile(academic);
    }
}

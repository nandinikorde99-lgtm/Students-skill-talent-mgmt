package module1_login_registration;

abstract class User {
    private int userId;
    private String name, email, password;

    public User(int userId, String name, String email, String password) {
        this.userId = userId; this.name = name; this.email = email; this.password = password;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public boolean checkPassword(String p) { return password.equals(p); }
    public abstract void login();
}

class Student extends User {
    public Student(int id, String n, String e, String p) { super(id,n,e,p); }
    @Override public void login() { System.out.println("Student login successful: " + getName()); }
}

class Admin extends User {
    public Admin(int id, String n, String e, String p) { super(id,n,e,p); }
    @Override public void login() { System.out.println("Admin login successful: " + getName()); }
}

class RegistrationManager {
    public User registerStudent(int id, String n, String e, String p) {
        return new Student(id,n,e,p);
    }
}

class LoginManager {
    public void login(User user) { user.login(); }
}

class AuthenticationService {
    public boolean authenticate(User user, String password) {
        return user.checkPassword(password);
    }
}

public class Main {
    public static void main(String[] args) {
        RegistrationManager rm = new RegistrationManager();
        User student = rm.registerStudent(1, "Huzeifa", "student@example.com", "1234");
        AuthenticationService auth = new AuthenticationService();
        if (auth.authenticate(student, "1234")) {
            new LoginManager().login(student);
        } else {
            System.out.println("Invalid password");
        }
    }
}

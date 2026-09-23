package module4_admin_dashboard;

abstract class Report {
    private String reportName;
    public Report(String name){ reportName=name; }
    public String getReportName(){ return reportName; }
    public abstract void generateReport();
}

class Dashboard { public void show(){ System.out.println("Admin Dashboard"); } }
class AnalyticsReport extends Report {
    public AnalyticsReport(){ super("Analytics Report"); }
    @Override public void generateReport(){ System.out.println("Generating analytics report"); }
}
class UserReport extends Report {
    public UserReport(){ super("User Report"); }
    @Override public void generateReport(){ System.out.println("Generating user report"); }
}
class SystemSettings {
    private boolean maintenanceMode;
    public void setMaintenanceMode(boolean value){ maintenanceMode=value; }
    public boolean isMaintenanceMode(){ return maintenanceMode; }
}
class AuditLog { public void record(String action){ System.out.println("Audit: "+action); } }

public class Main {
    public static void main(String[] args) {
        new Dashboard().show();
        Report r1 = new AnalyticsReport();
        Report r2 = new UserReport();
        r1.generateReport();
        r2.generateReport();
        new AuditLog().record("Reports generated");
    }
}

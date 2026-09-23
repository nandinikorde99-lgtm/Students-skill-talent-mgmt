package module3_skill_management;

abstract class Skill {
    private int skillId;
    private String name, level, category;
    public Skill(int id, String name, String level, String category) {
        this.skillId=id; this.name=name; this.level=level; this.category=category;
    }
    public String getName() { return name; }
    public abstract void evaluateSkill();
}

class TechnicalSkill extends Skill {
    public TechnicalSkill(int id, String n, String l, String c) { super(id,n,l,c); }
    @Override public void evaluateSkill() { System.out.println("Technical skill evaluated: " + getName()); }
}

class SoftSkill extends Skill {
    public SoftSkill(int id, String n, String l, String c) { super(id,n,l,c); }
    @Override public void evaluateSkill() { System.out.println("Soft skill evaluated: " + getName()); }
}

class SkillCategory { private String name; public SkillCategory(String n){name=n;} }
class SkillAssessment { public void assess(Skill s){ s.evaluateSkill(); } }
class SkillManager { public void addSkill(Skill s){ System.out.println("Skill added: "+s.getName()); } }

public class Main {
    public static void main(String[] args) {
        Skill technical = new TechnicalSkill(1, "Java", "Intermediate", "Programming");
        SkillManager manager = new SkillManager();
        manager.addSkill(technical);
        new SkillAssessment().assess(technical);
    }
}

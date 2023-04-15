package lib.model;

public enum EmployeeGrade {

    FIRST(3000000),
    SECOND(5000000),
    THIRD(7000000);

    private final int baseSalary;

    EmployeeGrade(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }
}

package lib.model;

import java.time.LocalDate;

/**
 * Menggambarkan data kepegawaian dari Person
 */
public class Employee {

    private final String employeeId;
    private final Person person;
    private final LocalDate joinedAt;
    private final EmployeeGrade grade;
    private final boolean isForeigner;


    /**
     * Memodelkan objek Employee
     *
     * @param employeeId id dari employee
     * @param person objek utama dari employee
     * @param joinedAt tanggal bergabung
     * @param grade tingkatan pekerja
     * @param isForeigner status kepegawaian asing
     */
    public Employee(String employeeId, Person person, LocalDate joinedAt, EmployeeGrade grade, boolean isForeigner) {
        this.employeeId = employeeId;
        this.person = person;
        this.joinedAt = joinedAt;
        this.grade = grade;
        this.isForeigner = isForeigner;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getJoinedAt() {
        return joinedAt;
    }

    public EmployeeGrade getGrade() {
        return grade;
    }

    public boolean isForeigner() {
        return isForeigner;
    }
}

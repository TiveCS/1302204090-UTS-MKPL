package lib.model;

import java.util.LinkedList;
import java.util.List;

public class Person {

    private final String idNumber;
    private final String name;
    private final String address;
    private final Gender gender;

    private Person spouse = null;

    private final List<Person> children;

    private int otherMonthlyIncome = 0;
    private int annualDeductible = 0;

    public Person(String idNumber, String name, String address, Gender gender) {
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.gender = gender;

        this.children = new LinkedList<>();
    }

    public void setAnnualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public Person getSpouse() {
        return spouse;
    }

    public List<Person> getChildren() {
        return children;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }
}

package lib.calculator;

import lib.model.Employee;
import lib.model.Person;

import java.time.LocalDate;

public class TaxCalculator {

    private static final int MIN_INCOME_TAX = 54000000;
    private static final int MARRIED_ADDITION_MIN_TAX = 4500000;
    private static final int PER_CHILD_ADDITION_MIN_TAX = 1500000;

    public static int getAnnualIncomeTax(Employee employee) {
        LocalDate date = LocalDate.now(), joinedAt = employee.getJoinedAt();

        final int monthWorkingInYear = date.getYear() == joinedAt.getYear() ? date.getMonthValue() - joinedAt.getMonthValue() : 12;

        return calculateTax(employee, monthWorkingInYear);
    }

    public static int calculateTax(Employee employee, final int numberOfMonthWorking) {
        Person person = employee.getPerson();

        int tax;
        int numberOfChildren = Math.min(person.getChildren().size(), 3);
        boolean isMarried = person.getSpouse() != null;

        int incomeByMonthWorking = IncomeCalculator.getMonthlyIncome(employee) * numberOfMonthWorking;
        int deductible = employee.getPerson().getAnnualDeductible();

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        if (isMarried) {
            tax = (int) Math.round(0.05 * ((incomeByMonthWorking - deductible - (MIN_INCOME_TAX + MARRIED_ADDITION_MIN_TAX + (numberOfChildren * PER_CHILD_ADDITION_MIN_TAX)))));
        }else {
            tax = (int) Math.round(0.05 * ((incomeByMonthWorking - deductible - MIN_INCOME_TAX)));
        }

        return Math.max(tax, 0);
    }
}

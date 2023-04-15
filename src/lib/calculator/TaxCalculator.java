package lib.calculator;

import lib.model.Employee;
import lib.model.Person;

import java.time.LocalDate;

public class TaxCalculator {

    private static final int MIN_INCOME_TAX = 54000000;
    private static final int MARRIED_ADDITION_MIN_TAX = 4500000;
    private static final int PER_CHILD_ADDITION_MIN_TAX = 1500000;

    /**
     * Mendapatkan pendapatan bersih setelah
     * @param employee
     * @return
     */
    public static int getAnnualIncomeTax(Employee employee) {
        LocalDate date = LocalDate.now(), joinedAt = employee.getJoinedAt();

        final int monthWorkingInYear = date.getYear() == joinedAt.getYear() ? date.getMonthValue() - joinedAt.getMonthValue() : 12;

        return calculateTax(employee, monthWorkingInYear);
    }

    /**
     * Menghitung pajak berdasarkan waktu Employee bekerja
     *
     * @param employee objek employee
     * @param numberOfMonthWorking waktu bekerja dalam bulan
     * @return pajak dalam 5%
     */
    public static int calculateTax(Employee employee, final int numberOfMonthWorking) {
        Person person = employee.getPerson();

        int tax;
        int minimumIncomeToGetTax = getMinimumIncomeToGetTax(person);

        int incomeByMonthWorking = IncomeCalculator.getMonthlyIncome(employee) * numberOfMonthWorking;
        int deductible = employee.getPerson().getAnnualDeductible();

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        tax = (int) (Math.round(0.05 * ((incomeByMonthWorking - deductible - minimumIncomeToGetTax))));

        return Math.max(tax, 0);
    }

    /**
     * Mendapatkan minimum penghasilan untuk kena pembayaran pajak
     *
     * @param person objek person
     * @return minimum penghasilan untuk kena pajak
     */
    private static int getMinimumIncomeToGetTax(Person person) {
        boolean isMarried = person.getSpouse() != null;
        int numberOfChildren = Math.min(person.getChildren().size(), 3);

        int minimumIncome = MIN_INCOME_TAX;

        if (isMarried) {
            minimumIncome += MARRIED_ADDITION_MIN_TAX + (numberOfChildren * PER_CHILD_ADDITION_MIN_TAX);
        }

        return minimumIncome;
    }
}

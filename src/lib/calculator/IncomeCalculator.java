package lib.calculator;

import lib.model.Employee;

public class IncomeCalculator {

    private final static int FOREIGNER_BASE_SALARY = (int) (3000000 * 1.5);

    public static int getMonthlyIncome(Employee employee) {
        return getSalary(employee) + employee.getPerson().getOtherMonthlyIncome();
    }

    private static int getSalary(Employee employee) {
        if (employee.isForeigner()) return FOREIGNER_BASE_SALARY;

        return employee.getGrade().getBaseSalary();
    }

}

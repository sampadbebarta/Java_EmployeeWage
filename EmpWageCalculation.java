import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeWageComputationProblem {


	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	private static final boolean Integer = false;

	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	private HashMap<Integer,Integer> dailyEmpWageMap;

	EmployeeWageComputationProblem() {
		companyEmpWageArray = new ArrayList<>();
		dailyEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		companyEmpWageArray.add(new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth));
		numOfCompany++;
	}

	public void computeEmpWage() {
		for(int i = 0;i < numOfCompany; i++) {
			companyEmpWageArray.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpWageArray.get(i)));
			computeDailyWage();
			System.out.println(companyEmpWageArray.get(i));
			System.out.println();
		}
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage ) {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while(totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;
			int employeeCheck = (int)Math.floor(Math.random() * 10) % 3;

			switch (employeeCheck) {
			case IS_PART_TIME:
				empHrs = 4;
				break;
			case IS_FULL_TIME:
				empHrs = 8;
				break;
			default:
				empHrs = 0;
			}
			totalEmpHrs += empHrs;
			dailyEmpWageMap.put(totalWorkingDays, companyEmpWage.empRatePerHour * empHrs);
		}
		return totalEmpHrs * companyEmpWage.empRatePerHour;
	}

	private void computeDailyWage() {
		for(Map.Entry<Integer, Integer> dailyEmpWage : dailyEmpWageMap.entrySet() ) {
			System.out.println("For Day "+ dailyEmpWage.getKey() +" Emp Wage is: "+dailyEmpWage.getValue());
		}

	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Employee Wage Computation Problem");
		EmployeeWageComputationProblem empWageBuilder = new EmployeeWageComputationProblem();
		empWageBuilder.addCompanyEmpWage("dMart", 20, 2, 10);
		empWageBuilder.addCompanyEmpWage("jioMart", 10, 4, 20);
		empWageBuilder.computeEmpWage();
	}

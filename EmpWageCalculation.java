import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeWageComputationProblem implements IComputeEmpWage {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> companyEmpWageArray;
	private HashMap<Integer,Integer> dailyEmpWageMap;
	private HashMap<String,CompanyEmpWage> companyToEmpWageMap;

	EmployeeWageComputationProblem() {
		companyEmpWageArray = new ArrayList<>();
		dailyEmpWageMap = new HashMap<>();
		companyToEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageArray.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
	}

	public void computeEmpWage() {
		for(int i = 0;i < companyEmpWageArray.size(); i++) {
			companyEmpWageArray.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpWageArray.get(i)));
			System.out.println(companyEmpWageArray.get(i));
		}
	}

	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
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
			System.out.println("Day#: "+ totalWorkingDays +"Emp Hr: "+empHrs);
			dailyEmpWageMap.put(totalWorkingDays, companyEmpWage.empRatePerHour * empHrs);
		}
		return totalEmpHrs * companyEmpWage.empRatePerHour;
	}


	public static void main(String[] args) {
		System.out.println("Welcome to the Employee Wage Computation Problem");
		EmployeeWageProblemUC14 empWageBuilder = new EmployeeWageProblemUC14();
		empWageBuilder.addCompanyEmpWage("dMart", 20, 2, 10);
		empWageBuilder.addCompanyEmpWage("jioMart", 10, 4, 20);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for the DMart company: "+ ( empWageBuilder).getTotalWage("dMart"));
	}
}

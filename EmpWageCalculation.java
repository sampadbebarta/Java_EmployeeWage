public class EmpWageCalculation {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 2;
	public static final int MAX_HRS_IN_MONTH = 10;

	public static void computeEmployeeWage() {
		// variables
		int empHrs = 0, totalWorkingDays = 0, totalEmpHrs = 0;
		// computation
		while(totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
			totalWorkingDays++;
			int employeeCheck = (int)Math.floor(Math.random() * 10) % 3;
			// Check whether Employee is working as a full time or part time or not working.
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
			System.out.println("Day: "+totalWorkingDays);
			System.out.println(" Emp Hr: "+empHrs);
		}
		int totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
		// Total Employee Wage for the hours Employee has worked
		System.out.println("Total Emp Wage: " + totalEmpWage);
	}

	public static void main(String[] args){
		System.out.println("Welcome to the Employee Wage Computation Problem");
		computeEmployeeWage();
	}
}

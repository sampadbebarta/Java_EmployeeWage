public class EmpWageCalculation{
	public static void main(String args[]){
		//Constants
		final int IS_FULL_TIME = 1;
		final int EMP_RATE_PER_HOUR = 20;
		//variables
		int empHrs =  0;
		int empWage = 0;
		//Computation
		double empCheck = Math.floor(Math.random() * 10) % 2;
		if (empCheck == IS_FULL_TIME) {
			System.out.println("Employee is Present");
			empHrs = 8;
		}
		else
			System.out.println("Employee is Absent");
		empWage = empHrs * EMP_RATE_PER_HOUR;
		System.out.println("Emp Wage: "+empWage);
	}
}

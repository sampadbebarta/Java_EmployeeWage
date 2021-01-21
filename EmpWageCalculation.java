public class EmpWageCalculation
{
    public static void main( String[] args )
    {
    	final int IS_FULL_TIME = 1;
    	final int IS_PART_TIME= 2;
    	final int PER_HOUR_WAGE = 20;
    	final int MAX_WORKING_HRS = 100;
    	final int MAX_WORKING_DAYS = 15;
    	int totalWorkingHrs=0;
    	int totalWage=0;
    	int days=0;
    	while(totalWorkingHrs< MAX_WORKING_HRS && days < MAX_WORKING_DAYS) {
    		int noOfHrs = 0;
    		final int empCheck = (int)Math.floor(Math.random() * 10)%3;
    		switch(empCheck) {
    		case IS_FULL_TIME: 	noOfHrs = 8;
    						days += 1;
    						System.out.println("Employee is Full Time");
    						break;
    		case IS_PART_TIME:	noOfHrs = 4;
    						days += 1;
    						System.out.println("Employee is Part Time");
    						break;
    		default:			System.out.println("Employee is Absent");
    		}
    		totalWorkingHrs += noOfHrs;
    		final int empWage= noOfHrs*PER_HOUR_WAGE;
    		totalWage+=empWage;
    	}
    	if(totalWorkingHrs>=100)
    		System.out.println( "Employee's wage for completing " + MAX_WORKING_HRS + " or more Hrs " + totalWage);
    	else
    		System.out.println("Employee's wage after working for " + MAX_WORKING_DAYS + " or more days, his/her wage is " + totalWage);
    }
}

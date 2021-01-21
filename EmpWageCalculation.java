public class EmpWageCalculation
{
    public static void main( String[] args )
    {
    	final int IS_FULL_TIME = 1;
    	final int IS_PART_TIME= 2;
    	final int PER_HOUR_WAGE = 20;
    	int noOfHrs = 0;
    	int empWage=0;
    	final int empCheck = (int)Math.floor(Math.random() * 10)%3;
    	switch(empCheck) {
    	case IS_FULL_TIME: 	noOfHrs = 8;
    						System.out.println("Employee is Full Time");
    						break;
    	case IS_PART_TIME:	noOfHrs = 4;
    						System.out.println("Employee is Part Time");
    						break;
    	default:			System.out.println("Employee is Absent");
    	}
    	empWage= noOfHrs*PER_HOUR_WAGE;
        System.out.println( "Employee's wage for the day :" + empWage);
    }
}

public class EmpWageCalculation
{
    public static void main( String[] args )
    {
		System.out.println( "Welcome to Employee Wage Computation");
    	int IS_FULL_TIME=1;
    	double empCheck = Math.floor(Math.random() * 10)%2;
    	if(IS_FULL_TIME == empCheck)
    		System.out.println("Employee is Present");
    	else
    		System.out.println("Employee is Absent");
    }
}

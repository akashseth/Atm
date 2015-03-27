
    import java.util.Scanner;
    import java.util.InputMismatchException;
    public class Atm {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int user_choice,atm_pin,database_pin=1234,balance=6000,input_amount,pin_digit;
		int wrong_pin_limit=3;
		boolean pin_validation,user_input_string;
		String continue_option;
		welcome_message();
		/*Taking input till user want*/
	  do  
	  {
		/*
		 * Taking user pin input
		 */
		atm_pin=atm_pin_input();
		pin_digit=user_input_pin_digit(atm_pin);
		/*
		 * Matching user pin with database
		 */
		pin_validation=validateInputPin(atm_pin,database_pin);
		/*
		 * Checking if atm pin input is not of four digits
		 */
		if(pin_digit!=4)
		{
			System.out.println("You have entered incorrect pin digit");
			System.exit(0);
		}
		/*
		 * Checking if entered pin is correct
		 */
		else if(pin_validation)
		{	
			wrong_pin_limit=3;  //Initializing wrong_pin_limit=3 if user input correct pin//
			/*
			 * Displaying option to be chosen by user
			 */
			display_option();
			/*
			 * Taking user choice
			 */
			user_choice=displayed_option_input_by_user();
			switch(user_choice)
			{
			 case 1:System.out.println("Your balance is:"+balance);
			   		break;
			   		/*
			   		 * Taking user input amount
			   		 */
			 case 2:input_amount=user_input_amount();
			 		balance=withdarw_checking_condition(input_amount,balance);//Updating balance//
			 		break;
			 case 3:System.out.println("\t\t\tTHANK YOU");
				 	System.exit(0);
			 		break;
			 default:System.out.println("Yow have Entered wrong choice.Please re-enter again");
			}
		}
		else
		{
			/*
			 * Displaying wrong pin limit and updating it
			 */
			wrong_pin_limit=display_wrong_pin_input(wrong_pin_limit);
		}
		    /*
		     * Checking if user want to user services again
		     */
		continue_option=service_continue_option_checking();
		    /*
		     * Checking if user input yes or no
		     */
		user_input_string=!( (( (continue_option).equals("yes") || (continue_option).equals("YES") )) || (( (continue_option).equals("no")|| (continue_option).equals("NO") )) );
			/*
			 * Forcing user to input only yes or no
			 */
		forcing_user_to_input_yes_or_no(user_input_string, continue_option);
	  }while((continue_option).equals("yes") ||(continue_option).equals("YES"));
	  		/*
	  		 * End of main method
	  		 */
	  System.out.println("  \t\t\t !!!! Thank you !!!!");
	}
    	/*
    	 * Method for welcome message
    	 */
    public static void welcome_message()
    {
    	System.out.println("\t\t\tWelcome to HDFC Bank");
		System.out.println("Insert your card");
    }
    	/*
    	 * Method for taking atm pin input
    	 */
    public static int atm_pin_input()
	{   	
		int atm_pin=0;
		System.out.println("Enter your pin");
		Scanner scan= new Scanner(System.in);
		try{    //Preventing program from crash due to invalid input//
		atm_pin=scan.nextInt();
		}catch(Exception ex)
		{	
			System.out.println("You have input invalid numbers or characters which is not allowed");
			System.exit(0);
		}
		return atm_pin;
	}
    	/*
    	 * Method for checking total digit of input pin
    	 */
    public static int user_input_pin_digit(int atm_pin)
    {
    	int digit=0;
    	while(atm_pin!=0)
    	{
    		atm_pin/=10;
    		digit++;
    	}
    	return digit;
    }
    	/*
    	 * Method for Validating user input pin
    	 */
 	public static boolean validateInputPin(int atm_pin, int database_pin )
    	{ 
    	boolean flag=false;
    	if(atm_pin==database_pin)
    	flag=true;
    	return flag;
    	}
    	/*
    	 * Method for displaying option available to user
    	 */
	public static void display_option()
	{
	        System.out.println("1.Check Balance");
	        System.out.println("2.Withdraw");
	        System.out.println("3.Exit");
		System.out.println("Enter your choice");
	}	
	/*
	 * Method for taking user choice on option available to user
	 */
	public static int displayed_option_input_by_user()
	{
		int user_choice=0;
		Scanner scan=new Scanner(System.in);
		try{   //Preventing program from crash due to invalid input//
		user_choice=scan.nextInt();
		}catch(Exception ex)
		{	
			System.out.println("You have input invalid numbers or characters which is not allowed");
			System.exit(0);
		}
		return user_choice;
	}
	/*
	 * Method for checking withdraw condition
	 */
	public static int withdarw_checking_condition(int input_amount, int balance)
	{
		if(balance<=0)
		 System.out.println("You have insufficient balance");
		 else if(input_amount<=0 || input_amount%100!=0)
		 System.out.println("You have input invalid amount.Please enter amount multiple of 100");
	 	 else if(balance<input_amount)
	 	 System.out.println("You have insufficient balance");
	 	 else if(input_amount<=balance)
	 	 {	
	 	  balance=balance_deduction(balance,input_amount);
	 	  System.out.println("\tTransaction completed. Please collect your cash");
	 	  }
		 return balance;
	}
	/*
	 * Method for taking amount from user
	 */
	public static int user_input_amount()
	{
		int user_amount=0;
		System.out.println("Enter amount");
		Scanner scan= new Scanner(System.in);
		try{   //Preventing program from crash due to invalid input//
		user_amount=scan.nextInt();
		}catch(Exception ex)
		{	
			System.out.println("You have input invalid numbers or characters which is not allowed");
			System.exit(0);
		}
		return user_amount;
	}
	/*
	 * Method for updating balance
	 */
	public static int balance_deduction(int balance, int input_amount)
	{
		balance=balance-input_amount;
		return balance;
	}
	/*
	 * Method for warning user not to enter wrong pin
	 */
	public static int display_wrong_pin_input(int wrong_pin_limit)
	{
		System.out.println("You have entered Invalid pin.Please enter correct pin");
	    wrong_pin_limit--;
	    wrong_pin_warning(wrong_pin_limit);
	    return wrong_pin_limit;
	}
	/*
	 * Method for Checking if user input three times wrong pin continuously
	 */
	public static void wrong_pin_warning(int wrong_pin_limit)
	{
		if(wrong_pin_limit==0)
	       {
	    	 System.out.println("You have entered WRONG PIN three times and now your atm is blocked for today\n\t\t\t!!!!   Thank you  !!!!");
	    	 System.exit(0); 
	       }
	       System.out.println("You have only "+wrong_pin_limit+" more chance and after that your atm will be blocked for today ");
	}
	/*
	 * Method for Forcing user to input only yes or no
	 */
	public static String forcing_user_to_input_yes_or_no(boolean user_input_string, String continue_option)
	{
		int input_limit=0;
		do{        //Forcing user to input only 'yes' or'no'//
	         if(user_input_string )
	          {
	          input_limit++;
	          input_limit_for_loop(input_limit);
	    	  System.out.println("You have entered wrong key. Please re-enter 'yes' for continue or 'no' for exit ");
	    	  Scanner scan=new Scanner(System.in);
	          continue_option=scan.nextLine();
	          }
	         }while(user_input_string);
		return continue_option;
	}
	/*
	 * Method for preventing user to input unusual key continuously
	 */
	public static void input_limit_for_loop(int input_limit)
	{   
		if(input_limit>=3)
		{
			System.out.println("Input limit Exceeded");
			System.exit(0);
		}
	}
	/*
	 * Method for checking if user want to use service again
	 */
	public static String service_continue_option_checking()
	{
		String continue_option;
		System.out.println("Do you want to use services again? Enter 'yes' for continue or 'no' for exit");
		Scanner scan=new Scanner(System.in);
        continue_option=scan.nextLine();
        return continue_option;
	}
	   
}


import java.util.Scanner;
import java.util.InputMismatchException;
public class Atm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice=0,amount=0,chance=3,balance=6000;
		String atm_pin, data_pin="1122",conti;
		
		System.out.println("\t\t\tWelcome to HDFC Bank");
		System.out.println("Insert your card");
	   do
		{
		   System.out.println("Enter your pin");
		   Scanner scan= new Scanner(System.in);
		   atm_pin=scan.nextLine();
		   if((atm_pin).equals(data_pin))  //Matching user pin with database//
		   {	
			 chance=3;   //Resetting user input chance=3//
			 
			 do       //Taking input till user want//
			 { 	
				 try{   //Preventing program from crash due to invalid input//
             System.out.println("1.Check Balance");
			 System.out.println("2.Withdraw");
			 System.out.println("Enter your choice");
			 choice=scan.nextInt();
			 		
			 switch(choice)
			    {
			    	
			   case 1: System.out.println("Your balance is:"+balance);
					   break;
			   case 2: 
				       System.out.println("Enter amount");
				       amount=scan.nextInt();
				       if(amount<0 || amount==0 || amount%100!=0)  //Preventing user from filling invalid amount//
				    	  do{
					        System.out.println("You have entered invalid amount please re-enter amount of multiple of 100");
					        amount=scan.nextInt();
				    	    }while(amount<0);
				       if(balance<amount)
				    	 do{
						   System.out.println("You have insufficient balance.Please re-enter amount again");
						   amount=scan.nextInt();
				    	   }while(balance<amount);
						  
				       if( (amount<balance || amount==balance)  && amount>0)
				         {
					       System.out.println("\tTransaction completed. Please collect your cash");
					       balance=balance-amount;
				         }
				        break;
			    default: System.out.println("Yow have Entered wrong choice.Please re-enter again");
			     } 
				 	   }catch (InputMismatchException ex)
		                {
				 		  scan.nextLine();  //Consume character left over//
		        	     System.out.println("Your have input other than numbers which is not allowed");
		                }
			   }while(choice!=1 && choice!=2);
			
              System.out.println("Do you want to use services again? Enter 'yes' for continue or 'no' for exit");
                    scan.nextLine(); //Consume character left over//
			  conti=scan.nextLine();
			      do{       //Forcing user to input only 'yes' or 'no'//
			      if( !((conti).equals("yes") || (conti).equals("no")) )
			          {
			    	  System.out.println("You have entered wrong key. Please re-enter 'yes' for continue or 'no' for exit ");
			          conti=scan.nextLine();
			          }
			        }while( !((conti).equals("yes") || (conti).equals("no")) );
		    }
		   else
		    {
		      System.out.println("You have entered Invalid pin .Please enter correct pin");
		      chance=chance-1;
		      if(chance==0)   //Checking if user input three times wrong pin continously//
		       {
		    	  System.out.println("You have entered WRONG PIN three times and now your atm is blocked for today\n\t\t\t!!!!   Thank you  !!!!");
		    	  System.exit(0); 
		       }
		       System.out.println("You have only "+chance+" more chance and after that your atm will be blocked for today ");
		       System.out.println("Do you want to enter again? Enter 'yes' for continue or 'no' for exit");
		       conti=scan.nextLine();
		       do{        //Forcing user to input only 'yes' or'no'//
		         if( !((conti).equals("yes") || (conti).equals("no")) )
		          {
		    	  System.out.println("You have entered wrong key. Please re-enter 'yes' for continue or 'no' for exit ");
		          conti=scan.nextLine();
		          }
		         }while( !((conti).equals("yes") || (conti).equals("no")) );
		     }
	 }while((conti).equals("yes") );
		
		          System.out.println("  \t\t\t !!!! Thank you !!!!");
  }

}


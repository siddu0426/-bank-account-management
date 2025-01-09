package myprojects;
import java.util.Scanner;

//Bank Account Management System
public class BankAccountManagement {    //main class

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); //scanner method
		BankAccount account = null;   //creating an object for the BankAccount class and initiating it to null
		
		while(true)      //options provided/displayed on the screen for the user 
		{
		System.out.println("     ---------------Bank Account Management---------------     ");
		System.out.println("1. Create an Account");
		System.out.println("2. Deposit money");
		System.out.println("3. Withdraw money");
		System.out.println("4. Display account Details");
		System.out.println("Exit");
		
		//making user selecting the choice
		System.out.println("Enter your choice");
		int choice = sc.nextInt(); 
		
		switch(choice)
		{
		case 1 : 
			//creating a new account as per user requirements by making user give the input
			System.out.println("Enter account no.");
			String AccountNumber = sc.next();
			System.out.println("Enter Name of Account holder");
			String Name = sc.next();
			System.out.println("Enter initial balance");
			double initialbalance = sc.nextDouble();
			account = new BankAccount(initialbalance, AccountNumber, Name);
			System.out.println("Account has been successfully created!");
			break;
			
		case 2:
			//for depositing money
			if(account != null)
			{
				System.out.println("Enter amount to be deposited");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
			}
			else {
				System.out.println("No account found");
				System.out.println("Please create one");
			}
			break;
			
		case 3:
			//for withdrawing the money
			if(account != null)
			{
				System.out.println("Enter amount to be withdrawn");
				double withdrawamount = sc.nextDouble();
				account.withdraw(withdrawamount);
			}
			else {
				System.out.println("No account found");
			}
			break;
			
		case 4:
			if(account != null)
			{
				account.displayAccountDetails();
			}
			else {
				System.out.println("There is no account");
				System.out.println("Please create one");
			}
			break;
			
		case 5:
			//exit from the bank account management system
			System.out.println("Thankyou for using the Bank Account Management System");
			sc.close();
			return;
			
			default:
				System.out.println("Invalid choice! Please try again");
			
		}
	}
		
	}
}
class BankAccount
{
	
	private double balance;  
	//creating a variable balance and making it to private so that only this class could access not other classes
	private String AccountNumber;
	//same for the account number
	private String Name;
	//same for the name of the account holder
	
	public BankAccount(double balance, String AccountNumber, String Name)
	// constructor to receive data from main method by the use and making it used here
	{
		this.balance = balance;
		this.AccountNumber = AccountNumber;
		this.Name = Name;
	}
	
	//getters i.e., data fetching/ returning data to the user
	public double getbalance()
	{
		return balance;
	}
	public String getAccountNumber()
	{
		return AccountNumber;
	}
	public String getName()
	{
		return Name;
	}
	// end of getters
	public void deposit(double amount) //for depositing amount
	{
		//condition for making the amount added in the balance
		if(amount > 0)     
		{
			System.out.println("Deposited" + amount +"in your account");
			balance += amount;
		}
		else
		{
			System.out.println("Deposited amount must be greater than zero");
		}
	}
	
	public void withdraw(double amount)
	{
		if(amount < balance)
		{
			System.out.println("Withdrawn "+amount);
			balance -= amount;
			System.out.println("Balance is "+ balance);
		}
		else if(amount > balance)
		{
			System.out.println("Insufficient balance!");
		}
		else
		{
			System.out.println("Withdrawl amount must be greater than zero");
		}
	}
	
	public void displayAccountDetails()
	{
		System.out.println("Account holder name is"+Name);
		System.out.println("Account no. is"+AccountNumber);
		System.out.println("Your balance is"+balance);
	}
}

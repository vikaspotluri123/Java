public class BankAccount
{
	private String name;
	private double balance;
	private int accountNumber;
	
	//default constructor
	public BankAccount()
	{
		name = "<Insert name here>";
		balance = 0;
		accountNumber = 0;
	}
	//secondary constrcutor
	public BankAccount(String n, double b, int a)
	{
		name = n;
		balance = b;
		accountNumber = a;
	}
	//to string
	public String toString()
	{
		return name + "  " + balance + "  " + "  " + accountNumber;
	}	
	
	public String getName()
	{
		return name;
	}
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public double getBalance()
	{
		return balance;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}
	public void setAccountNumber(int n)
	{
		this.accountNumber = n;
	}
	public void deposit(double amount)
	{
		balance += amount;
	}
	public void withdraw(double amount)
	{
		balance -= amount;
	}
}
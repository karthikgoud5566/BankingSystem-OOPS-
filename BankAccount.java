package com.bl.el;

public class BankAccount {

    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public double withDraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return balance;
        } else {
            System.out.println("Insufficient funds.");
            return 0;
        }
    }

    public String checkBalance() {
        return "Your bank balance is: " + balance;
    }
}

class SavingsAccount extends BankAccount {

    private double interestRate = 0.04;

    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public double addInterest() {
        double interest = balance * interestRate;
        deposit(interest); // add interest to balance
        System.out.println("Interest added: " + interest);
        return interest;
    }
}


class CurrentAccount extends BankAccount
 {
	private double overdraftlimit;
	

	public CurrentAccount(int accountNumber, String accountHolder, double balance,double overdraftlimit) {
		super(accountNumber, accountHolder, balance);
		this.overdraftlimit=overdraftlimit;
	}
	
	public double withDraw(double amount)
	{
		if(balance+overdraftlimit>=amount)
		{
			balance-=amount;
			return amount;
			
		}
		else {
			System.out.println("exceeded limit");
			return 0;
		}
		
	}	 
 }

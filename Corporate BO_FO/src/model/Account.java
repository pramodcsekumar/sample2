package model;

public class Account {
	private String AccountName, Branch,UserName,password;
	private int userId,currency,Balance;
	
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		this.Balance = balance;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		this.AccountName = accountName;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		this.Branch = branch;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int AccountNumber;
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.AccountNumber = accountNumber;
	}
	

}
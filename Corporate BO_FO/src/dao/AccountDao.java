package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.User1;

public class AccountDao {
	public   int save(Account u){
		int status=0;
		try{
			Connection con=MySqlConn.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Account values(?,?,?,?,?,?,?,?)");
		 
			ps.setInt(1,u.getUserId());
			ps.setInt(2,u.getAccountNumber());
			ps.setString(3,u.getAccountName());
		 	ps.setString(4,u.getBranch());
			ps.setInt(5,u.getCurrency());
			ps.setInt(6,u.getBalance());
			ps.setString(7,u.getUserName());
			ps.setString(8,u.getPassword());
			
			status=ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	
	public   int update(Account u){
		int status=0;
		try {
			Connection con = MySqlConn.getCon();

			PreparedStatement ps = con.prepareStatement("update corporate set AccountNumber=?,userId=?,AccountName=?,Branch=?,Currency=?,Balance=?,UserName=?,Password=? where AccountNumber=?");
			System.out.println("AccountNumber= " +u.getAccountNumber()+" "+ u.getUserId() + " " +u.getAccountName()+" "+u.getBranch()+" "+u.getBalance()+" "+u.getCurrency()+" "+u.getUserName()+ " " +u.getPassword());
			
			ps.setInt(1,u.getUserId());
			ps.setInt(2,u.getAccountNumber());
			ps.setString(3,u.getAccountName());
		 	ps.setString(4,u.getBranch());
			ps.setInt(5,u.getCurrency());
			ps.setInt(6,u.getBalance());
			ps.setString(7,u.getUserName());
			ps.setString(8,u.getPassword());
			status = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		} 
		return status;
	}
	
	
	public int delete(int AccountNumber) {
		int status=0;
		try{
			Connection con=MySqlConn.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Account where AccountNumber=?");
			ps.setInt(1,AccountNumber);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
			}

		return status;
	}
	
	public Account getRecordById(int AccountNumber) {
		Account u = null;
		try {
			Connection con = MySqlConn.getCon();
			PreparedStatement ps = con.prepareStatement("select * from Account where AccountNumber=?");
			ps.setInt(1, AccountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
					u = new Account();
					ps.setInt(1,u.getUserId());
					ps.setInt(2,u.getAccountNumber());
					ps.setString(3,u.getAccountName());
				 	ps.setString(4,u.getBranch());
					ps.setInt(5,u.getCurrency());
					ps.setInt(6,u.getBalance());
					ps.setString(7,u.getUserName());
					ps.setString(8,u.getPassword());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}

	public List<Account> getAllRecords() {
		List<Account> list = new ArrayList<Account>();

		try {
			Connection con = MySqlConn.getCon();
			PreparedStatement ps = con.prepareStatement("select * from Account");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account u = new Account();
				ps.setInt(1,u.getUserId());
				ps.setInt(2,u.getAccountNumber());
				ps.setString(3,u.getAccountName());
			 	ps.setString(4,u.getBranch());
				ps.setInt(5,u.getCurrency());
				ps.setInt(6,u.getBalance());
				ps.setString(7,u.getUserName());
				ps.setString(8,u.getPassword());
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}

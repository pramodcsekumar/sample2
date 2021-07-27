package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User1;

public class UserDao {
	public   int save(User1 u){
		int status=0;
		try{
			Connection con=MySqlConn.getCon();
			PreparedStatement ps=con.prepareStatement("insert into user(id,userId,name,department,address,phonenumber)  values(?,?,?,?,?,?)");
		 
			ps.setInt(1,u.getId());
			ps.setInt(2,u.getUserId());
			ps.setString(3,u.getName());
			ps.setString(4,u.getDepartment());
		 	ps.setString(5,u.getAddress());
			ps.setString(6,u.getPhonenumber()); 
			
			status=ps.executeUpdate();
		} 
		catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public   int update(User1 u){
		int status=0;
		try {
			Connection con = MySqlConn.getCon();

			PreparedStatement ps = con.prepareStatement("update user set id=?,userId=?,name=?,department=?,address=?,phonenumber=?, where userId=?"+ "values(?,?,?,?,?,?)");
			System.out.println("userId= " + u.getUserId() +" "+u.getId()+ " " + u.getName() + " " + u.getDepartment()+" "+u.getAddress()+" "+u.getPhonenumber());
			ps.setInt(1, u.getUserId());
			ps.setInt(2, u.getId());
			ps.setString(3, u.getName());
			ps.setString(4, u.getDepartment());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getPhonenumber());
		

			status = ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		} 
		return status;
	}
	
	
	public int delete(int userId) {
		int status=0;
		try{
			Connection con=MySqlConn.getCon();
			PreparedStatement ps=con.prepareStatement("delete from user where userId=?");
			ps.setInt(1,userId);
			status=ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
			}

		return status;
	}
	
	public User1 getRecordById(int userId) {
		User1 u = null;
		try {
			Connection con = MySqlConn.getCon();
			PreparedStatement ps = con.prepareStatement("select * from user where userId=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
					u = new User1();
				u.setId(rs.getInt("id"));
				u.setUserId(rs.getInt("userId"));
				u.setName(rs.getString("name"));
				u.setDepartment(rs.getString("department"));
				u.setAddress(rs.getString("address"));
				u.setPhonenumber(rs.getString("phonenumber"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}

	public List<User1> getAllRecords() {
		List<User1> list = new ArrayList<User1>();

		try {
			Connection con = MySqlConn.getCon();
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User1 u = new User1();
				u.setId(rs.getInt("id"));
				u.setUserId(rs.getInt("userId"));
				u.setName(rs.getString("name"));
				u.setDepartment(rs.getString("department"));
				u.setAddress(rs.getString("address"));
				u.setPhonenumber(rs.getString("phonenumber"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}


}

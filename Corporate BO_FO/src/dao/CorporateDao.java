package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Corporate1;

public class CorporateDao {
	public   int save(Corporate1 u){
		int status=0;
		try{
			Connection con=MySqlConn.getCon();
			PreparedStatement ps=con.prepareStatement("insert into corporate values(?,?,?)");
		 
			//ps.setInt(1,u.getId());
			ps.setString(1,u.getName());
		 	ps.setString(2,u.getAddress());
			ps.setString(3,u.getPhonenumber());
			
			status=ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	public   int update(Corporate1 u) {
		int status=0;
		try {
			Connection con = MySqlConn.getCon();

			PreparedStatement ps = con.prepareStatement("update corporate set name=?,address=?,phonenumber=?, where id=?");
			System.out.println("id= " + u.getId() + " " + u.getName() + " " + u.getAddress()+" "+u.getPhonenumber());
			ps.setString(1,u.getName());
		 	ps.setString(2,u.getAddress());
			ps.setString(3,u.getPhonenumber());
			
			status = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		} 
		return status;
	}
	
	
	
	
	public int delete(int id) {
		int status=0;
		try{
			Connection con=MySqlConn.getCon();
			PreparedStatement ps=con.prepareStatement("delete from corporate where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
			}

		return status;
	}
	
	
	public Corporate1 getRecordById(int id) {
		Corporate1 u = null;
		try {
			Connection con = MySqlConn.getCon();
			PreparedStatement ps = con.prepareStatement("select * from corporate where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
					u = new Corporate1();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAddress(rs.getString("address"));
				u.setPhonenumber(rs.getString("phonenumber"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}

	public List<Corporate1> getAllRecords() {
		List<Corporate1> list = new ArrayList<Corporate1>();

		try {
			Connection con = MySqlConn.getCon();
			PreparedStatement ps = con.prepareStatement("select * from corporate");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Corporate1 u = new Corporate1();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
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

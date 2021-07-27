package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User1;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao uDao = new UserDao();   
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		System.out.println(action);
		switch(action)
		{
		case "add":
			insert(request,response);
		    break;
		case "update":
			update(request,response);
			break;
		case "delete":
			delete(request,response);
		    break;
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	  User1 user=new User1();
	  	int cid = Integer.parseInt(request.getParameter("id"));
	  	int uid = Integer.parseInt(request.getParameter("userId"));
	  	user.setUserId(uid);  
	  	user.setId(cid);  
	  	
	  	user.setName(request.getParameter("name"));
	  	user.setDepartment(request.getParameter("department"));
	  	user.setAddress(request.getParameter("address"));
	  	user.setPhonenumber(request.getParameter("phonenumber"));
	  	
	  			 
	  	int i=uDao.save(user);
	  	if(i>0){
	  	response.sendRedirect("adduser-success1.jsp");
	  }  
	  	   else{ response.sendRedirect("adduser-error1.jsp");
	  	 
	  	}
	  	}
	    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	User1 user = new User1();
	    			
	    	int cid = Integer.parseInt(request.getParameter("id"));
		  	int uid = Integer.parseInt(request.getParameter("userId"));
		  	user.setUserId(uid);  
		  	user.setId(cid);  
		  	
		  	user.setName(request.getParameter("name"));
		  	user.setDepartment(request.getParameter("department"));
		  	user.setAddress(request.getParameter("address"));
		  	user.setPhonenumber(request.getParameter("phonenumber"));
		  	
	    			int i = uDao.update(user);
	    			if (i > 0) {
	    				System.out.println("Data updated successfully");
	    				response.sendRedirect("view1.jsp");
	    			} else {
	    				System.out.println("Sorry, an error occured while updating record");
	    				response.sendRedirect("index.jsp");
	    			}
	    			 
	    				
	    		}
	    		 
	    		
	    		 
	    		protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		 
	    		int userId=Integer.parseInt(request.getParameter("userId"));
	    		 
	    			  int i=uDao.delete(userId);
	    			  if(i>0){
	    	  			  response.sendRedirect("view1.jsp");
	    	}else
	    	{ response.sendRedirect("adduser-error1.jsp"); }
	    	 
	    			 

	    	}
	    	}

		

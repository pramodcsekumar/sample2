package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import model.Account;
import model.Corporate1;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	AccountDao aDao=new AccountDao();
    public AccountController() {
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
	  	  Account A=new Account();
	  	int uid = Integer.parseInt(request.getParameter("userId"));
	  	int Anumber= Integer.parseInt(request.getParameter("AccountNumber"));
	  	int c= Integer.parseInt(request.getParameter("Currency"));
	  	int b= Integer.parseInt(request.getParameter("Balance"));
	  	A.setUserId(uid); 
	  	A.setAccountNumber(Anumber);
	  	A.setAccountName(request.getParameter("AccountName"));
	  	A.setBranch(request.getParameter("Branch"));
	  	A.setCurrency(c);
	  	A.setBalance(b);
	  	A.setUserName(request.getParameter("userName"));
	  	A.setPassword(request.getParameter("password"));
	  			 
	  	int i=aDao.save(A);
	  	if(i>0){
	  	response.sendRedirect("adduser-success2.jsp");
	  }  
	  	   else{ response.sendRedirect("adduser-error2.jsp");
	  	 
	  	}
	  	}
	 protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Account A=new Account();
		  	
		 int uid = Integer.parseInt(request.getParameter("userId"));
		  	int Anumber= Integer.parseInt(request.getParameter("AccountNumber"));
		  	int c= Integer.parseInt(request.getParameter("Currency"));
		  	int b= Integer.parseInt(request.getParameter("Balance"));
		  	A.setUserId(uid); 
		  	A.setAccountNumber(Anumber);
		  	A.setAccountName(request.getParameter("AccountName"));
		  	A.setBranch(request.getParameter("Branch"));
		  	A.setCurrency(c);
		  	A.setBalance(b);
		  	A.setUserName(request.getParameter("userName"));
		  	A.setPassword(request.getParameter("password"));
		  			 

	    			int i = aDao.update(A);
	    			if (i > 0) {
	    				System.out.println("Data updated successfully");
	    				response.sendRedirect("view2.jsp");
	    			} else {
	    				System.out.println("Sorry, an error occured while updating record");
	    				response.sendRedirect("index.jsp");
	    			}
	    			 
	    				
	    		}
	 
	 protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
 		int id=Integer.parseInt(request.getParameter("AccountNumber"));
 		 
 			  int i=aDao.delete(id);
 			  if(i>0){
 	  			  response.sendRedirect("view2.jsp");
 	}else
 	{ response.sendRedirect("adduser-error2.jsp"); }
 	 
 		}

}

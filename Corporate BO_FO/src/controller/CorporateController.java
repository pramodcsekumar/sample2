package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CorporateDao;
import model.Corporate1;

/**
 * Servlet implementation class CorporateController
 */
@WebServlet("/CorporateController")
public class CorporateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CorporateDao crDao = new CorporateDao();

	public CorporateController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "add":
			insert(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		}

	}

	 protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	  Corporate1 corporate=new Corporate1();
	  	  //int id =Integer.parseInt(request.getParameter("id"));
	  	//System.out.println(id);
	  	//corporate.setId(id);  
	  	corporate.setName(request.getParameter("name"));
	  	corporate.setAddress(request.getParameter("address"));
	  	corporate.setPhonenumber(request.getParameter("phonenumber"));
	  			 
	  	int i=crDao.save(corporate);
	  	if(i>0){
	  	response.sendRedirect("adduser-success.jsp");
	  }  
	  	   else{ response.sendRedirect("adduser-error.jsp");
	  	 
	  	}
	  	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Corporate1 corporate = new Corporate1();

		// corporate.setId((Integer.parseInt(request.getParameter("id"))));

		//int id = (Integer.parseInt(request.getParameter("id")));
		//corporate.setId(id);
		corporate.setName(request.getParameter("name"));
		corporate.setAddress(request.getParameter("address"));
		corporate.setPhonenumber(request.getParameter("phonenumber"));

		int i = crDao.update(corporate);
		if (i > 0) {
			System.out.println("Data updated successfully");
			response.sendRedirect("view.jsp");
		} else {
			System.out.println("Sorry, an error occured while updating record");
			response.sendRedirect("index.jsp");
		}

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		int i = crDao.delete(id);
		if (i > 0) {
			response.sendRedirect("view.jsp");
		} else {
			response.sendRedirect("adduser-error.jsp");
		}

	}
}

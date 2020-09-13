package com.simplilearn.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Registration.html");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		Cookie ck1=new Cookie("name", firstname);
		response.addCookie(ck1);
		String gender=request.getParameter("gender");
		switch (gender) {
		case "male":
			gender="male";
			break;
		case "female":
			gender="female";
			break;	
		default:
			gender="others";
			break;
		}
		String countryCode=request.getParameter("country code");
		if(countryCode.matches("/^(\\+?\\d{1,3}|\\d{1,4})$/gm")) {
			response.getWriter().println("<h5> invalid country code !.. </h5>");
		}
		String phone = request.getParameter("phone");
		if(phone.matches("/^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$/g")) {
			response.getWriter().println("<h5> invalid phone number !.. </h5>");
		}
		String email = request.getParameter("email");
		if(!email.matches("^(.+)@(.+)$")) {
			response.getWriter().println("<h5> invalid Email !.. </h5>");
		}
		String address=request.getParameter("address");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repass");
		response.getWriter().println("<h1>User Details<br/><br/>"
				+ firstname+"<br/>"+
				lastname+"<br/>"+gender+"<br/>"+countryCode+phone+"<br/>"+
				email+"<br/>"+address);
	}
}

package com.simplilearn.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("feedback.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String experience = request.getParameter("experience");
		String comments = request.getParameter("comments");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println("experience " +experience);
		System.out.println("name " +name);
		response.setContentType("text/html");
		
		if(!name.isEmpty() && !email.isEmpty() && !comments.isEmpty() && !experience.isEmpty()) {
			response.getWriter().println("<h2>Successfully submited the feedback !</h2>");
			response.getWriter().println("<ul>");
			response.getWriter().println("<li> Name : " +name +"</li>");
			response.getWriter().println("<li> Eamil : " +email +"</li>");
			response.getWriter().println("<li> Experience : " +experience +"</li>");
			response.getWriter().println("<li> Comments : " +comments +"</li>");
			response.getWriter().println("<ul>");
//			Cookie[] ck=request.getCookies();
//			response.getWriter().print(ck[0].getName());
		}else {
			response.getWriter().println("<h2>Invalid feedback !</h2>");
		}
		
	}

}

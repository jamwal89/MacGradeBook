

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.DBGradebook;
import customtools.DBGradebookUser;
import model.Gradebook;
import model.Gradebookuser;

/**
 * Servlet implementation class GradebookuserServlet
 */
@WebServlet("/GradebookuserServlet")
public class GradebookuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradebookuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextURL="";
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		
		String name =request.getParameter("username");
		String password =request.getParameter("password");
		
		
		if (DBGradebookUser.isValidUser(name, password)) {
			System.out.println("userfound");
			Gradebookuser gb = DBGradebookUser.getUserByname(name);
			session.setAttribute("user", gb);
			
			
			long userid=gb.getUserid();
			System.out.println("user id is :" + userid);
			
			
			List<Gradebook> grades= null;
			grades=DBGradebook.gradesofuser(userid);
			session.setAttribute("grades", grades);
			
			nextURL="/Gradespage.jsp";
			
			
		}
		else{
			System.out.println("User not found");
			nextURL = "/GradeBookLogin.jsp";
		}
		
	  	response.sendRedirect(request.getContextPath() + nextURL);
	
	}

}



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.DBGradebook;

import model.Gradebook;

/**
 * Servlet implementation class DetailUpdateServlet
 */
@WebServlet("/DetailUpdateServlet")
public class DetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailUpdateServlet() {
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

	/**x
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextURL;
		System.out.println("We are in method");
		String updateduserid=request.getParameter("UserID");
		String updatedsubject=request.getParameter("Subject");
		String updatedassignment=request.getParameter("Assignment");
		String updatedgrade=request.getParameter("Grade");
		
		
		
		HttpSession session = request.getSession();
		
		Gradebook upadtedStudent= (Gradebook) session.getAttribute("student");
		
		upadtedStudent.setUserid(Integer.parseInt(updateduserid));
		upadtedStudent.setSubject(updatedsubject);
		upadtedStudent.setAssignment(updatedassignment);
		upadtedStudent.setGrade(updatedgrade);
		
		
		System.out.println(" User detail Update");
		DBGradebook.update(upadtedStudent);
		System.out.println("Done");
		nextURL="/Final.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
		
	}

}

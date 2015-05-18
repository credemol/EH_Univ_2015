package kr.ac.ewha.helloworld.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.ewha.helloworld.dao.UserDao;
import kr.ac.ewha.helloworld.dao.UserDaoImpl;
import kr.ac.ewha.helloworld.domain.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		UserDao userDao = new UserDaoImpl();

		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println("<html><body>");
			writer.println("<h1>User List</h1>");
			writer.println("<ul>");
			for(User user : userDao.getAllUsers()) {
				writer.println("<li><a href='mailto:" + user.getEmail() + "'>" + user.getDisplayName() + "</a></li>");
			}
			writer.println("</ul>");
			writer.println("</body></html>");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
	*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDaoImpl();

		Collection<User> users = userDao.getAllUsers();
		System.out.println("users: " + users);
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/jsp/user/list.jsp").forward(request, response);
	}
	
}

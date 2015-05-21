package kr.ac.ewha.helloworld.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.ewha.helloworld.dao.UserDao;
import kr.ac.ewha.helloworld.dao.UserDaoImpl;
import kr.ac.ewha.helloworld.domain.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUser(id);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/WEB-INF/jsp/user/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User();
		int id = Integer.parseInt(request.getParameter("id"));
		
		user.setId(id);
		user.setLoginId(request.getParameter("loginId"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setDisplayName(request.getParameter("displayName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		System.out.println("user: " + user);
		
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		
		response.sendRedirect("UserViewServlet?id=" + id);
	}

}

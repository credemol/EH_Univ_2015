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
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/UserViewServlet")
public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		UserDao userDao = new UserDaoImpl();
		
		User user = userDao.getUser(id);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/user/view.jsp")
			.forward(request, response);
		
	}

}

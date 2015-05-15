package kr.ac.ewha.helloworld.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter writer = null;
		
		try {
			writer = response.getWriter();
			
			writer.println("<html>");
			writer.println("  <header>");
			writer.println("    <title>Hello World Service</title>");
			writer.println("  </header>");
			writer.println("  <body>");
			writer.println("    <h1>Hello World</h1>");
			writer.println("  </body>");
			writer.println("</html>");
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}

}

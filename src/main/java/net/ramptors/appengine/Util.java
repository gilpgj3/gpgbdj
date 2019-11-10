package net.ramptors.appengine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	public static void procesa(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response,
			Exception e) throws ServletException, IOException {
		request.setAttribute("error", e.getMessage());
		servlet.log("Error", e);
		request.getRequestDispatcher("FormError.jsp").forward(request, response);
	}
}

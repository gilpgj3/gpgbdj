package com.appspot.gpgbdj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ramptors.appengine.Util;

@WebServlet(name = "CtrlPasatiempoElimina", urlPatterns = { "/CtrlPasatiempoElimina" })
public class CtrlPasatiempoElimina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			final String id = request.getParameter("id");
			if (id == null || id.isEmpty()) {
				throw new Error("Falta el id.");
			}
			Fire.BD.collection("Pasatiempo").document(id).delete().get();
			response.sendRedirect("CtrlPasatiempos");
		} catch (Exception e) {
			Util.procesa(this, request, response, e);
		}
	}
}
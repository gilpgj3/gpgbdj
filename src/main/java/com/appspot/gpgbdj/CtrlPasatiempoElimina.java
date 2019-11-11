package com.appspot.gpgbdj;

import static com.appspot.gpgbdj.Fire.BD;
import static net.ramptors.appengine.Util.procesa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			BD.collection("Pasatiempo").document(id).delete().get();
			response.sendRedirect("CtrlPasatiempos");
		} catch (Exception e) {
			procesa(this, request, response, e);
		}
	}
}
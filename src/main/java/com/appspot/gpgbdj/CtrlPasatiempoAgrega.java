package com.appspot.gpgbdj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;	
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ramptors.appengine.Util;

@WebServlet(name = "CtrlPasatiempoAgrega", urlPatterns = { "/CtrlPasatiempoAgrega" })
public class CtrlPasatiempoAgrega extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			final String nombre = request.getParameter("nombre");
			if (nombre == null || nombre.isEmpty()) {
				throw new Exception("Falta el nombre");
			} else {
				Fire.BD.collection("Pasatiempo").add(new InfoPasatiempo(null, nombre)).get();
			}
			response.sendRedirect("CtrlPasatiempos");
		} catch (Exception e) {
			Util.procesa(this, request, response, e);
		}
	}
}
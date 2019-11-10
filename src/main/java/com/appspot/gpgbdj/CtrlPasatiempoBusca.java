package com.appspot.gpgbdj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;

import net.ramptors.appengine.Util;

@WebServlet(name = "CtrlPasatiempoBusca", urlPatterns = { "/CtrlPasatiempoBusca" })
public class CtrlPasatiempoBusca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			final String id = request.getParameter("id");
			if (id == null || id.isEmpty()) {
				throw new Error("Falta el id.");
			}
			final ApiFuture<DocumentSnapshot> f = Fire.BD.collection("Pasatiempo").document(id).get();
			final DocumentSnapshot doc = f.get();
			if (doc.exists()) {
				final InfoPasatiempo modelo = doc.toObject(InfoPasatiempo.class);
				request.setAttribute("modelo", modelo);
				request.getRequestDispatcher("FormPasatiempo.jsp").forward(request, response);
			} else {
				throw new Exception("No se localizó el registro.");
			}
		} catch (Exception e) {
			Util.procesa(this, request, response, e);
		}
	}
}
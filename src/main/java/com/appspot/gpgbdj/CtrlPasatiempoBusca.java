package com.appspot.gpgbdj;

import static com.appspot.gpgbdj.Fire.BD;
import static net.ramptors.appengine.Util.procesa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;

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
			final ApiFuture<DocumentSnapshot> f = BD.collection("Pasatiempo").document(id).get();
			final DocumentSnapshot doc = f.get();
			if (doc.exists()) {
				request.setAttribute("modelo", doc.getData());
				request.getRequestDispatcher("FormPasatiempo.jsp").forward(request, response);
			} else {
				throw new Exception("No se localizó el registro.");
			}
		} catch (Exception e) {
			procesa(this, request, response, e);
		}
	}
}
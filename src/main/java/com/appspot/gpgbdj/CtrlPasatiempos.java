package com.appspot.gpgbdj;

import static com.appspot.gpgbdj.Fire.BD;
import static net.ramptors.appengine.Util.procesa;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@WebServlet(name = "CtrlPasatiempos", urlPatterns = { "/CtrlPasatiempos" })
public class CtrlPasatiempos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			final ApiFuture<QuerySnapshot> query = BD.collection("Pasatiempo").get();
			final QuerySnapshot querySnapshot = query.get();
			final List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
			final List<Map<String, Object>> lista = documents.stream().map(doc -> {
				final Map<String, Object> modelo = doc.getData();
				modelo.put("id", doc.getId());
				return modelo;
			}).collect(Collectors.toList());
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("FormPasatiempos.jsp").forward(request, response);
		} catch (Exception e) {
			procesa(this, request, response, e);
		}
	}
}
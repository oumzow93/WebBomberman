package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DaoFactory;
import db.UtilisateurDaoImpl;
import form.Utilisateur;



@WebServlet("/MonCompte")

public class MonCompte extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MonCompte() {	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDaoImpl utilisateur= new UtilisateurDaoImpl(DaoFactory.getInstance()) ;
		HttpSession session = request.getSession();
		Utilisateur utilisateurs = utilisateur.InformationUser((String) session.getAttribute("utilisateur"));
		request.setAttribute("MonUtilisateur", utilisateurs);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/monCompte.jsp").forward(request, response);
		System.out.println(utilisateurs);
	}
	
}




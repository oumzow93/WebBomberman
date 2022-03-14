package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DaoFactory;
import db.UtilisateurDao;
import db.UtilisateurDaoImpl;
import form.Utilisateur;

@WebServlet("/Utilisateurs")
public class Utilisateurs extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UtilisateurDao utilisateurDao;
	
	public Utilisateurs() {	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDaoImpl utilisateur= new UtilisateurDaoImpl(DaoFactory.getInstance()) ;
		List<Utilisateur> utilisateurs = utilisateur.lister();
		
		
		request.setAttribute("utilisateurs", utilisateurs);
		request.getRequestDispatcher("/WEB-INF/pages/utilisateur.jsp").forward(request, response);
		System.out.println(utilisateurs);
		//this.getServletContext().getRequestDispatcher("/WEB-INF/pages/utilisateur.jsp").forward(request, response);
	}
	
}


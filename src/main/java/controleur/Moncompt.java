package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DaoFactory;
import db.PartieDAO;
import db.UtilisateurDao;
import bean.Partie;
import bean.Utilisateur;

/**
 * Servlet implementation class Moncompt
 */
@WebServlet("/Moncompt")
public class Moncompt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
	private PartieDAO partieDao;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Moncompt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDao();
		this.partieDao = daoFactory.getPartieDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utilisateur utilisateurs =  this.utilisateurDao.InformationUser((String) session.getAttribute("utilisateur"));

		ArrayList<Partie> partie = this.partieDao.Afficher((String) session.getAttribute("utilisateur"));
		request.setAttribute("MonUtilisateur", utilisateurs);
		request.setAttribute("Parties", partie);



		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/moncompte.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("supprimer")!=null) {
			
			HttpSession session= request.getSession();

			//SUPPRIMER L'UTILISATEUR CONNECTÉ

			this.utilisateurDao.supprimerUtilisateur((String) session.getAttribute("utilisateur"));
			response.sendRedirect("home");

			session.invalidate();


		}
		//MODIFIER L'UTILISATEUR CONNECTÉ
		if(request.getParameter("update")!=null) {





			String logUser = request.getParameter( "pseudo" );
			String nom = request.getParameter( "nom" );
			String prenom = request.getParameter( "prenom" ) ;
			String email = request.getParameter( "email" );
			String password = request.getParameter( "password" );

			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo(logUser);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setPassword(password);
			this.utilisateurDao.modifierUtilisateur(utilisateur);

			request.setAttribute("nom_utilisateur", logUser);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("password", password);

			this.utilisateurDao.InformationUser(logUser);
			request.setAttribute("MonUtilisateur", utilisateur);



			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/moncompte.jsp").forward(request, response);


		}


	}

}

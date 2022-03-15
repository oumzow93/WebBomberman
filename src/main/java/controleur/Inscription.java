package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MesExceptions.DaoException;
import db.DaoFactory;
import db.UtilisateurDao;
import form.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UtilisateurDao utilisateurDao;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String logUser = (request.getParameter( "nom_utilisateur" ) != null) ? request.getParameter( "nom_utilisateur" ) : "";
		String nom = (request.getParameter( "nom" ) != null) ? request.getParameter( "nom" ) : "";
		String prenom = (request.getParameter( "prenom" ) != null) ? request.getParameter( "prenom" ) : "";
		String email = (request.getParameter( "email" ) != null) ? request.getParameter( "email" ) : "";
		
		
		request.setAttribute("nom_utilisateur", logUser);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("email", email);
		
		
		

		//this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(request, response);
		
		try {
			//doGet(request, response);
			Utilisateur uti = new Utilisateur();
			uti.setPseudo(request.getParameter("nom_utilisateur"));
			uti.setPassword(request.getParameter("password"));
			uti.setConfirmPassword(request.getParameter("confirmation"));
			uti.setNom(request.getParameter("nom"));
			uti.setPrenom(request.getParameter("prenom"));
			uti.setEmail(request.getParameter("email"));
			this.utilisateurDao.ajouter(uti);
			request.setAttribute("succes", "Votre compte à été créer avec succès");
			
		}catch (DaoException e) {
			System.out.println(e.getMessage());
			 request.setAttribute("erreur", e.getMessage());
			
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(request, response);
	}

}

package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DaoFactory;
import db.UtilisateurDao;


/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UtilisateurDao utilisateurDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
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
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	


		
		if(this.utilisateurDao.authentification(request.getParameter("pseudo"), request.getParameter("password"))&& !this.utilisateurDao.estbloquer(request.getParameter("pseudo"))) {
			response.sendRedirect("home");
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", request.getParameter("pseudo"));
			if(this.utilisateurDao.EstAdmin(request.getParameter("pseudo"))) {
				session.setAttribute("Admin", "Admin");
			}
				
			
		}else if(this.utilisateurDao.estbloquer(request.getParameter("pseudo"))) {
			request.setAttribute("erreur", "Compte bloqué!");
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(request, response);
		}
		else {
			request.setAttribute("erreur", "Identifiant incorrect!");
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(request, response);
		}
		
	}

}

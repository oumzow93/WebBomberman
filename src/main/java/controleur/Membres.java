package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DaoFactory;
import db.UtilisateurDao;
import bean.Utilisateur;

/**
 * Servlet implementation class Membres
 */
@WebServlet("/Membres")
public class Membres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Membres() {
        super();
    }
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Utilisateur> utilisateurs = this.utilisateurDao.lister();
		ArrayList<String> statut = new ArrayList<>();
		for(Utilisateur uti:utilisateurs) {
			String pseudo =uti.getPseudo();
			if(this.utilisateurDao.estbloquer(pseudo)) {
				statut.add("bloquer");
				
			}else {
				statut.add("debloquer");
				
			}
		}
		
		request.setAttribute("utilisateurs", utilisateurs);
		request.setAttribute("statut",statut);
		
		
		request.getRequestDispatcher("/WEB-INF/pages/membres.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Valider")!=null) {
			
			System.out.println(request.getParameter("statut0"));
		}

		
		
		this.doGet(request, response);

	}
	
	
	


}

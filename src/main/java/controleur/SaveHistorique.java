package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MesExceptions.DaoException;
import bean.Historique;
import db.DaoFactory;
import db.HistoriqueDAO;

/**
 * Servlet implementation class SaveHistorique
 */
@WebServlet("/SaveHistorique")
public class SaveHistorique extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private HistoriqueDAO historiqueDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveHistorique() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.historiqueDao = daoFactory.getHistoriqueDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Historique historique= new Historique();
		historique.setJoueur(request.getParameter("pseudo"));
		historique.setPartie(request.getParameter("debut"));
		
		try {
			this.historiqueDao.ajouter(historique);
			System.out.println(historique.toString()+"Enregistrement avec Succes!");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}



}

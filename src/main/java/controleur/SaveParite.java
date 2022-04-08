package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MesExceptions.DaoException;
import bean.Partie;
import db.DaoFactory;
import db.PartieDAO;

/**
 * Servlet implementation class SaveParite
 */
@WebServlet("/SaveParite")
public class SaveParite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PartieDAO partieDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveParite() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.partieDao = daoFactory.getPartieDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Partie partie = new Partie();
		partie.setDateDebut(request.getParameter("debut"));
		partie.setDateFin(request.getParameter("fin"));
		
		if(Integer.parseInt(request.getParameter("mode"))==1) {
			partie.setMode("Solo");
		}else {
			partie.setMode("Multi-joueur");
		}
		partie.setScore(request.getParameter("score"));
		partie.setResultat(request.getParameter("resultat"));
		System.out.println(partie.toString());
		try {
			this.partieDao.ajouter(partie);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	
	}



}

package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import db.DaoFactory;
import db.UtilisateurDao;

/**
 * Servlet implementation class APIConnexion
 */
@WebServlet("/APIConnexion")
public class APIConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UtilisateurDao utilisateurDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIConnexion() {
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
		String pseudo = request.getParameter("pseudo");
		String password =request.getParameter("password");
		
		if(this.utilisateurDao.authentification(pseudo,password)) {
			//response.sendRedirect("home");
			//HttpSession session = request.getSession();
			//session.setAttribute("utilisateur", request.getParameter("pseudo"));
			PseudoPass  pseudpass = new PseudoPass();
			 pseudpass.setPseudo(pseudo);
			 pseudpass.setPassword(password);
			Gson gson= new Gson();
			
			String userJson = gson.toJson(pseudpass);
			PrintWriter sortie = response.getWriter();
			sortie.write(userJson);
			sortie.close();
		}
				
		
	}
	
	public class PseudoPass{
		private String pseudo;
		private String password;
		public String getPseudo() {
			return pseudo;
		}
		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
	

	

}

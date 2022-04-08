package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import MesExceptions.DaoException;
import bean.Partie;

public class PartieDaoImpl implements PartieDAO{
	
	
	private DaoFactory daoFactory;

	 PartieDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Partie partie) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO PARTIES(Debut,Fin,Mode,Score,Resultat) VALUES(?,?,?,?,?);");
			preparedStatement.setString(1, partie.getDateDebut());
			preparedStatement.setString(2, partie.getDateFin());
			preparedStatement.setString(3, partie.getMode());
			preparedStatement.setString(4, partie.getScore());
			preparedStatement.setString(5, partie.getResultat());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public  ArrayList<Partie> Afficher(String pseudo) {
		ArrayList<Partie> parties = new ArrayList<>();
		
        Connection connexion;
		try {
			connexion = (Connection) daoFactory.getConnection();
			Statement statement = connexion.createStatement();
			String request="SELECT Debut,Fin,Mode,Score,Resultat, Joueur FROM PARTIES P JOIN ESPRESENT E ON P.Debut= E.Partie";
			ResultSet result = statement.executeQuery(request);
			 while(result.next()) {
				 if(pseudo.equals(result.getString("Joueur"))) {
					 Partie partie= new Partie();
					 partie.setDateDebut(result.getString("Debut"));
					 partie.setDateFin(result.getString("Fin"));
					 partie.setMode(result.getString("Mode"));
					 partie.setScore(result.getString("Score"));
					 partie.setResultat(result.getString("Resultat"));
					 parties.add(partie);
				 }
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
		return parties;
	}

}

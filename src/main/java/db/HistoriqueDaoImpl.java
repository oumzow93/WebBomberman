package db;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import MesExceptions.DaoException;
import bean.Historique;


public class HistoriqueDaoImpl implements HistoriqueDAO {
	private DaoFactory daoFactory;
	
	HistoriqueDaoImpl (DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Historique historique) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO ESPRESENT(Partie,Joueur) VALUES(?,?);");
			preparedStatement.setString(1, historique.getPartie() );
			preparedStatement.setString(2, historique.getJoueur() );
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}

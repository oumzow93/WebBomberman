package db;

import MesExceptions.DaoException;
import bean.Historique;


public interface HistoriqueDAO {
	public  void ajouter( Historique historique ) throws DaoException;

}

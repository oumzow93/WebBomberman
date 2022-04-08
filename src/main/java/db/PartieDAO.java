package db;

import java.util.ArrayList;

import MesExceptions.DaoException;
import bean.Partie;


public interface PartieDAO {
	public  void ajouter( Partie partie ) throws DaoException;
	public  ArrayList<Partie> Afficher(String pseudo);

}

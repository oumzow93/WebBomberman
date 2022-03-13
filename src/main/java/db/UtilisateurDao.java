package db;

import java.util.List;

import MesExceptions.DaoException;
import form.Utilisateur;

public interface UtilisateurDao {
	
   public  void ajouter( Utilisateur utilisateur ) throws DaoException;
   public List<Utilisateur> lister();
   public boolean authentification(String pseudo, String password);

}

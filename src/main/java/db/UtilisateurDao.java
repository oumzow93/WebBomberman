package db;

import java.util.List;

import MesExceptions.DaoException;
import form.Utilisateur;

public interface UtilisateurDao {
	
   public  void ajouter( Utilisateur utilisateur ) throws DaoException;
   public List<Utilisateur> lister();
   public Utilisateur InformationUser(String pseudo);
   public boolean authentification(String pseudo, String password);
   public void modifierUtilisateur(String pseudo);
   public void supprimerUtilisateur(String pseudo);

}

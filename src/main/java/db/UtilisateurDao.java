package db;

import java.util.List;

import form.Utilisateur;

public interface UtilisateurDao {
	
   public  void ajouter( Utilisateur utilisateur );
   public List<Utilisateur> lister();

}

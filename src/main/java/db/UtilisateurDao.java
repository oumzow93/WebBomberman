package db;

import java.util.ArrayList;


import MesExceptions.DaoException;
import bean.Utilisateur;

public interface UtilisateurDao {
	
   public  void ajouter( Utilisateur utilisateur ) throws DaoException;
   public ArrayList<Utilisateur> lister();
   public boolean authentification(String pseudo, String password);
   public Utilisateur InformationUser(String pseudo) ;
   public void modifierUtilisateur (Utilisateur utilisateur );
   public void supprimerUtilisateur(String pseudo );
   public boolean EstAdmin(String pseudo);
   public boolean estbloquer(String pseudo);
   public void changerStatue(String statut, String pseudo);
   

}

package db;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import MesExceptions.DaoException;
import form.Utilisateur;



public class UtilisateurDaoImpl implements UtilisateurDao {

	private DaoFactory daoFactory;

	UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException{

		if(this.utlisateurExiste(utilisateur.getPseudo())) {// VERIFIER SI L'ITILISATEUR EXUSTE DANS LA BASE
			throw new DaoException("Ce nom d'utilisateur existe dejà! ");


		}
		else if(!this.verifPassword(utilisateur.getPassword(),utilisateur.getConfirmPassword())) {//  VEROFEIR SI LES 2 PASSWORD SON LES MEMES
			throw new DaoException("Les deux mot de passes doivent être identiques");
			
		}
		
		else {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			try {
				connexion = (Connection) daoFactory.getConnection();
				preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO 	UTILISATEURS(pseud, password, nom, prenom) VALUES(?, ?,?,?);");
				preparedStatement.setString(1, utilisateur.getPseudo());
				preparedStatement.setString(2, utilisateur.getPassword());
				preparedStatement.setString(3, utilisateur.getNom());
				preparedStatement.setString(4, utilisateur.getPrenom());

				preparedStatement.executeUpdate();


			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}


	}

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	//===========================METHODE PERMETTEN DE SAVOIR SI UN TULISATEUR EXISTE DEJA
	
	public boolean utlisateurExiste(String pseudo) {
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = (Connection) daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT pseud FROM UTILISATEURS;");

			while(resultat.next()) {
				if(pseudo.equals(resultat.getString("pseud"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}
	//===============================================COMMPARAISON DES DEUX PASSWORD LORS DE LA  CRÉATION D'UN COMPTER
	public boolean verifPassword(String p1, String p2) {
		return p1.equals(p2);
	}
	@Override
	public boolean authentification(String pseudo, String password) {
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = (Connection) daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT pseud, password FROM UTILISATEURS;");

			while(resultat.next()) {
				if(pseudo.equals(resultat.getString("pseud")) && password.equals(resultat.getString("password"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	//==============================================HASSAGE DU PASSWORD AVAN DE L'ENREGISTRE DANS BASSE
    public String Cripte(String password) {
    	
    	
    	
        String crypte= "";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48; 
            crypte=crypte+(char)c;
        }
        return crypte;
    
       
        /*String generatedPassword = "null";

        try 
        {
          // Create MessageDigest instance for MD5
          MessageDigest md = MessageDigest.getInstance("MD5");

          // Add password bytes to digest
          md.update(password.getBytes());

          // Get the hash's bytes
          byte[] bytes = md.digest();

          // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
          }

          // Get complete hashed password in hex format
          generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword;*/
    }


}

package db;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import MesExceptions.DaoException;
import bean.Utilisateur;



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
				preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO 	UTILISATEURS(pseud, password, nom, prenom,email, Type) VALUES(?,?,?,?,?,?);");
				preparedStatement.setString(1, utilisateur.getPseudo());
				preparedStatement.setString(2, this.Cripte(utilisateur.getPassword()));
				preparedStatement.setString(3, utilisateur.getNom());
				preparedStatement.setString(4, utilisateur.getPrenom());
				preparedStatement.setString(5, utilisateur.getEmail());
				preparedStatement.setString(6, "user");

				preparedStatement.executeUpdate();


			} catch (SQLException e) {
				e.printStackTrace();
			}

		}


	}

	@Override
	public ArrayList<Utilisateur> lister() {
		ArrayList<Utilisateur> utilisateurs= new ArrayList<>();
		try {
			Connection connexion = (Connection) daoFactory.getConnection();
			Statement statement = connexion.createStatement();
			ResultSet result = statement.executeQuery("SELECT pseud, password, nom, prenom, email FROM UTILISATEURS");
			while(result.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(result.getString(1));
				utilisateur.setNom(result.getString(3));
				utilisateur.setPrenom(result.getString(4));
				utilisateur.setEmail(result.getString(5));
				utilisateurs.add(utilisateur);
				//System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) + " " + result.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return utilisateurs;
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
		
		String PassCripter= this.Cripte(password);

		try {
			connexion = (Connection) daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT pseud, password FROM UTILISATEURS;");

			while(resultat.next()) {
				if(pseudo.equals(resultat.getString("pseud")) && PassCripter.equals(resultat.getString("password"))) {
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





		String generatedPassword = "null";

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
        //System.out.println(generatedPassword);
        return generatedPassword;
	}

	@Override
	public Utilisateur InformationUser(String pseudo) {
		try {
			Connection connexion = (Connection) daoFactory.getConnection();
			Statement statement = connexion.createStatement();
			ResultSet result = statement.executeQuery("SELECT pseud, password, nom, prenom, email FROM UTILISATEURS");
			while(result.next()) {
				if(pseudo.equals(result.getString("pseud"))) {
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setPseudo(result.getString(1));
					utilisateur.setNom(result.getString(3));
					utilisateur.setPrenom(result.getString(4));
					utilisateur.setEmail(result.getString(5));

					return utilisateur;

				}


				//System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) + " " + result.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;


		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("UPDATE UTILISATEURS SET pseud=?, nom=?, prenom=?, email=?, password=? ;");
			preparedStatement.setString(1, utilisateur.getPseudo());
			preparedStatement.setString(2, utilisateur.getNom());
			preparedStatement.setString(3, utilisateur.getPrenom());
			preparedStatement.setString(4, utilisateur.getEmail());
			preparedStatement.setString(5, utilisateur.getPassword());


			preparedStatement.executeUpdate();
			//preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void supprimerUtilisateur(String pseudo) {


		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("DELETE FROM UTILISATEURS WHERE pseud=?;");
			preparedStatement.setString(1, pseudo);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public boolean EstAdmin(String pseudo ) {
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = (Connection) daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT pseud,Type FROM UTILISATEURS;");

			while(resultat.next()) {
				if(pseudo.equals(resultat.getString("pseud")) && resultat.getString("Type").equals("admin")) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;

	}

	@Override
	public boolean estbloquer(String pseudo) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		
		try {
			connexion = (Connection) daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT pseud,Statut FROM UTILISATEURS;");

			while(resultat.next()) {
				if(pseudo.equals(resultat.getString("pseud")) && resultat.getString("Statut").equals("bloquer")) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void changerStatue(String statut ,String pseudo) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;


		try {
			connexion = (Connection) daoFactory.getConnection();
			preparedStatement = (PreparedStatement) connexion.prepareStatement("UPDATE UTILISATEURS SET Statut=? WHERE pseud=?");
			preparedStatement.setString(1, statut);
			preparedStatement.setString(2, pseudo);
			


			preparedStatement.executeUpdate();
			//preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}

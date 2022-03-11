package db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import form.Utilisateur;

public class User {
	private Connection connexion;



	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

		try {
			connexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/WebBomberman", "owele", "iuprt2014");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO 	UTILISATEURS(pseud, password, nom, prenom) VALUES(?, ?,?,?);");
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

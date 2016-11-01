package fr.univ_amu.iut.tpJDBC;

import java.sql.*;
import java.util.ArrayList;

public class testEntite {
    // La requete de test
    static final String req = "SELECT *" + "FROM ETUDIANT ";

    public static void main(String[] args) throws SQLException {

        ArrayList listEtu = new ArrayList();

        // Objet materialisant la connexion a la base de donnees
        try {
            Connection conn = ConnexionUnique.getInstance().getConnection();
            // Connexion a la base
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            //stockage dans l'arraylist
            Etudiant etu = new Etudiant();
            listEtu.add(rset);

            // Affichage des étudiants


            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
package fr.univ_amu.iut.tpJDBC;

import java.sql.*;
import java.util.ArrayList;

public class testEntite {
    // La requete de test
    static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET, CP_ET, VILLE_ET, ANNEE, GROUPE " + "FROM ETUDIANT";

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

            ArrayList <Etudiant> listEtudiant = new ArrayList();

            while (rset.next()){

                // création et initialisation des données de l'objet étudiant
                Etudiant etu = new Etudiant();
                etu.setNumEt(rset.getInt("NUM_ET"));
                etu.setNomEt(rset.getString("NOM_ET"));
                etu.setPrenomEt(rset.getString("PRENOM_ET"));
                etu.setCpEt(rset.getString("CP_ET"));
                etu.setVilleEt(rset.getString("VILLE_ET"));
                etu.setAnnee(rset.getInt("ANNEE"));
                etu.setGroupe(rset.getInt("GROUPE"));

                // ajoute l'objet dans l'arraylist
                listEtudiant.add(etu);
            }

            for (Etudiant etu : listEtudiant)

            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
package fr.univ_amu.iut.tpJDBC;

import java.sql.*;
import java.util.ArrayList;

public class testAsso1 {
    // Chaine de connexion
    static final String CONNECT_URL = "jdbc:mysql://mysql1.alwaysdata.com:3306/romain-colonna-distria_bd";
    static final String LOGIN = "113436";
    static final String PASSWORD = "752061322006";
    // La requete de test
    static final String req = "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF, ADR_PROF, CP_PROF, VILLE_PROF, MAT_SPEC, CODE, LIBELLE, H_COURS_PREV, H_COURS_REA, H_TP_PREV, H_TP_REA, DISCIPLINE, COEFF_TEST, COEFF_CC, RESP, CODEPERE " +
                              "FROM PROF JOIN MODULE ON PROF.MAT_SPEC = MODULE.CODE " +
                              "ORDER BY NUM_PROF ASC";

    public static void main(String[] args) throws SQLException {
        // Objet materialisant la connexion a la base de donnees
        Connection conn = null;
        try {
            // Connexion a la base
            System.out.println("Connexion a " + CONNECT_URL);
            conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            ArrayList<Prof> listProf = new ArrayList();

            while (rset.next()){

                // création et initialisation des données de l'objet prof
                Prof prof = new Prof ();
                Module mod = new Module ();

                mod.setCode(rset.getString("CODE"));
                mod.setLibelle(rset.getString("LIBELLE"));
                mod.sethCoursPrev(rset.getInt("H_COURS_PREV"));
                mod.sethCoursRea(rset.getInt("H_COURS_REA"));
                mod.sethTpPrev(rset.getInt("H_TP_PREV"));
                mod.sethTpRea(rset.getInt("H_TP_REA"));
                mod.setDiscipline(rset.getString("DISCIPLINE"));
                mod.setCoefTest(rset.getInt("COEFF_TEST"));
                mod.setCoefCc(rset.getInt("COEFF_CC"));
                //mod.setResponsable(rset.getInt("RESP"));
                //mod.setPere(rset.getInt("CODE_PERE"));

                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                prof.setAdrProf(rset.getString("ADR_PROF"));
                prof.setCpProf(rset.getString("CP_PROF"));
                prof.setVilleProf(rset.getString("VILLE_PROF"));
                prof.setSpecialite(mod);

                // ajoute l'objet dans l'arraylist
                listProf.add(prof);
            }

            for (Prof prof : listProf)
                System.out.println(prof);

            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        } finally {
            if (conn != null) {
                // Deconnexion de la base de donnees
                conn.close();
            }
        }
    }
}
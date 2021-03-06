package fr.univ_amu.iut.tpJDBC;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private int numEt;
    private String nomEt;
    private String prenomEt;
    private String cpEt;
    private String villeEt;
    private int annee;
    private int groupe;

    public Etudiant() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etudiant)) return false;

        Etudiant etudiant = (Etudiant) o;

        if (numEt != etudiant.numEt) return false;
        if (annee != etudiant.annee) return false;
        if (groupe != etudiant.groupe) return false;
        if (!nomEt.equals(etudiant.nomEt)) return false;
        if (!prenomEt.equals(etudiant.prenomEt)) return false;
        if (!cpEt.equals(etudiant.cpEt)) return false;
        return villeEt.equals(etudiant.villeEt);

    }

    @Override
    public int hashCode() {
        int result = numEt;
        result = 31 * result + nomEt.hashCode();
        result = 31 * result + prenomEt.hashCode();
        result = 31 * result + cpEt.hashCode();
        result = 31 * result + villeEt.hashCode();
        result = 31 * result + annee;
        result = 31 * result + groupe;
        return result;
    }

    @Override
    public String toString() {
        return "Etudiant : " + "numEt=" + numEt + ", nomEt='" + nomEt + '\'' + ", prenomEt='" + prenomEt + '\'' + ", cpEt='" + cpEt + '\'' + ", villeEt='" + villeEt + '\'' + ", annee=" + annee + ", groupe=" + groupe + '}';
    }

    public int getNumEt() {
        return numEt;
    }

    public void setNumEt(int numEt) {

        this.numEt = numEt;
    }

    public String getNomEt() {
        return nomEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public String getCpEt() {
        return cpEt;
    }

    public void setCpEt(String cpEt) {
        this.cpEt = cpEt;
    }

    public String getVilleEt() {
        return villeEt;
    }

    public void setVilleEt(String villeEt) {
        this.villeEt = villeEt;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }
}
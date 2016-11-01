package fr.univ_amu.iut.tpJDBC;

import java.io.Serializable;

public class Prof implements Serializable {
    private int numProf;
    private String nomProf;
    private String prenomProf;
    private String adrProf;
    private String cpProf;
    private String villeProf;
    private Module specialite;

    public Prof() {}

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(int numProf) {

        this.numProf = numProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public String getAdrProf() {
        return adrProf;
    }

    public void setAdrProf(String adrProf) {
        this.adrProf = adrProf;
    }

    public String getCpProf() {
        return cpProf;
    }

    public void setCpProf(String cpProf) {
        this.cpProf = cpProf;
    }

    public String getVilleProf() {
        return villeProf;
    }

    public void setVilleProf(String villeProf) {
        this.villeProf = villeProf;
    }

    public Module getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Module specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Prof : " + "numProf=" + numProf + ", nomProf='" + nomProf + '\'' + ", prenomProf='" + prenomProf + '\'' + ", adrProf='" + adrProf + '\'' + ", cpProf='" + cpProf + '\'' + ", villeProf='" + villeProf + '\'' + ", specialite=" + specialite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prof)) return false;

        Prof prof = (Prof) o;

        if (numProf != prof.numProf) return false;
        if (!nomProf.equals(prof.nomProf)) return false;
        if (!prenomProf.equals(prof.prenomProf)) return false;
        if (!adrProf.equals(prof.adrProf)) return false;
        if (!cpProf.equals(prof.cpProf)) return false;
        if (!villeProf.equals(prof.villeProf)) return false;
        return specialite.equals(prof.specialite);

    }

    @Override
    public int hashCode() {
        int result = numProf;
        result = 31 * result + nomProf.hashCode();
        result = 31 * result + prenomProf.hashCode();
        result = 31 * result + adrProf.hashCode();
        result = 31 * result + cpProf.hashCode();
        result = 31 * result + villeProf.hashCode();
        result = 31 * result + specialite.hashCode();
        return result;
    }
}
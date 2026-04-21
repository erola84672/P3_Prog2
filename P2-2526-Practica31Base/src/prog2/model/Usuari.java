package prog2.model;

import java.io.Serializable;

public abstract class Usuari implements InUsuari, Serializable {
    private String email;
    private String nom;
    private String adreca;

    public Usuari(String email, String nom, String adreca) {
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    @Override
    public String getAdreca() {
        return adreca;
    }

    @Override
    public abstract String tipusUsuari();

    @Override
    public abstract void setNumPrestecsNormals(int numPrestecsNormals);

    @Override
    public abstract int getNumPrestecsNormals();

    @Override
    public abstract void setNumPrestecsLlargs(int numPrestecstLlargs);

    @Override
    public abstract int getNumPrestecsLlargs();

    @Override
    public abstract int getMaxPrestecsNormals();

    @Override
    public abstract int getMaxPrestecsLlargs();

    @Override
    public String toString() {
        String info = ", Email=" + email + ", Nom=" + nom + ", Adreca=" + adreca;
        return info;
    }

}

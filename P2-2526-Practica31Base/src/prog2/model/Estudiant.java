package prog2.model;

public class Estudiant extends Usuari {
    private String tipusUsuari;
    private int numPrestecsNormals;
    private int numPrestecsLlargs;

    public Estudiant(String email, String nom, String adreca) {
        super(email, nom, adreca);
        this.tipusUsuari = tipusUsuari();
        this.numPrestecsNormals = getMaxPrestecsNormals();
        this.numPrestecsLlargs = getMaxPrestecsLlargs();
    }

    @Override
    public String tipusUsuari() {
        return "Estudiant";
    }

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }

    @Override
    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }

    @Override
    public void setNumPrestecsLlargs(int numPrestecsLlargs) {
        this.numPrestecsLlargs = numPrestecsLlargs;
    }

    @Override
    public int getNumPrestecsLlargs() {
        return numPrestecsLlargs;
    }

    @Override
    public int getMaxPrestecsNormals() {
        return 2;
    }

    @Override
    public int getMaxPrestecsLlargs() {
        return 1;
    }

    @Override
    public String toString() {
        String info = "Tipus=" + tipusUsuari;
        info += super.toString();
        info += ", Num. prestecs normals=" + numPrestecsNormals + ", Num. prestecs llargs=" + numPrestecsLlargs;

        return info;
    }
}

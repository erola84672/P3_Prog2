package prog2.model;

public class Estudiant extends Usuari {
    private String tipusUsuari;
    private int numPrestecsNormals;
    private int numPrestecsLlargs;

    public Estudiant(String email, String nom, String adreca) {
        super(email, nom, adreca);
        this.tipusUsuari = tipusUsuari();
        this.numPrestecsNormals = 0;
        this.numPrestecsLlargs = 0;
    }

    @Override
    public String tipusUsuari() {
        return "Estudiant";
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

        return info;
    }
}

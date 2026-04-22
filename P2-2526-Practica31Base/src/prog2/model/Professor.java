package prog2.model;

public class Professor extends Usuari {
    private String tipusUsuari;


    public Professor(String email, String nom, String adreca) {
        super(email, nom, adreca);
        this.tipusUsuari = tipusUsuari();
    }

    @Override
    public String tipusUsuari() {
        return "Professor";
    }

    @Override
    public int getMaxPrestecsNormals() {
        return 2;
    }

    @Override
    public int getMaxPrestecsLlargs() {
        return 2;
    }

    @Override
    public String toString() {
        String info = "Tipus=" + tipusUsuari;
        info += super.toString();

        return info;
    }
}

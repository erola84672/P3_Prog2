package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

public class PrestecNormal extends Prestec {
    private boolean retornat;
    private String tipusPrestec;
    private Date dataLimitRetorn;

    public PrestecNormal(Exemplar exemplar, Usuari usuari, Date dataCreacio) {
        super(exemplar, usuari, dataCreacio);
        this.tipusPrestec = tipusPrestec();
        this.retornat = false;
        this.dataLimitRetorn = getDataLimitRetorn();
    }

    @Override
    public void setDataLimitRetorn(Date data) {
        this.dataLimitRetorn = getDataCreacio() + (Date) duradaPrestec();
    }

    @Override
    public Date getDataLimitRetorn() {
        return getDataCreacio() + (Date) duradaPrestec();
    }

    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    @Override
    public void setRetornat(boolean retornat) {
        this.retornat = retornat;
    }

    @Override
    public boolean getRetornat() {
        return retornat;
    }

    @Override
    public void retorna() throws BiblioException {
        if (retornat)
            throw new BiblioException("L'exemplar ja ha estat retornat");
        else retornat = false;
    }

    @Override
    public long duradaPrestec() {
        return 70000;
    }

    @Override
    public boolean prestecEndarrerit() {
        Date actual = new Date();

        if (actual.after(dataLimitRetorn) && !retornat)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        String info = "Tipus=" + tipusPrestec;
        info += super.toString();
        info += ", Data límit retorn=" + dataLimitRetorn + ", Retornat=" + retornat;
        return info;
    }
}

package prog2.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Prestec implements InPrestec, Serializable {
    private Usuari usuari;
    private Exemplar exemplar;
    private Date dataCreacio;

    public Prestec(Exemplar exemplar, Usuari usuari, Date data) {
        this.usuari = usuari;
        this.exemplar = exemplar;
        this.dataCreacio = data;
    }

    @Override
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public Exemplar getExemplar() {
        return exemplar;
    }

    @Override
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Override
    public Usuari getUsuari() {
        return usuari;
    }

    @Override
    public void setDataCreacio(Date data) {
        this.dataCreacio = data;
    }

    @Override
    public Date getDataCreacio() {
        return dataCreacio;
    }

    @Override
    public abstract void setDataLimitRetorn(Date data);

    @Override
    public abstract Date getDataLimitRetorn();

    @Override
    public abstract String tipusPrestec();

    @Override
    public abstract void setRetornat(boolean retornat);

    @Override
    public abstract boolean getRetornat();

    @Override
    public abstract void retorna();

    @Override
    public abstract long duradaPrestec();

    @Override
    public abstract boolean prestecEndarrerit();

    @Override
    public String toString() {
        String info = ", Exemplar=" + exemplar + ", Usuari=" + usuari + ", Data de cracio=" + dataCreacio;
        return info;
    }
}

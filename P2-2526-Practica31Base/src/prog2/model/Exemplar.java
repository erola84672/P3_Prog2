package prog2.model;

import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String autor;
    private String titol;
    private boolean admetPrestecLlarg;
    private boolean disp;

    public Exemplar(String id, String titol, String autor, boolean admetPrestecLlarg) {
        this.id = id;
        this.autor = autor;
        this.titol = titol;
        this.admetPrestecLlarg = admetPrestecLlarg;
        this.disp = true;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }

    @Override
    public String getTitol() {
        return titol;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.admetPrestecLlarg = admetPrestecLlarg;
    }

    @Override
    public boolean getAdmetPrestecLlarg() {
        return admetPrestecLlarg;
    }

    public boolean isDisponible() {
        return disp;
    }

    public void setDisponible(boolean disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        String info = "Id=" + id + ", Titol=" + titol + ", Autor=" + autor + ", Admet Prestec Llarg=" +
        admetPrestecLlarg + ", Disponible=" + disp;
        return info;
    }
}

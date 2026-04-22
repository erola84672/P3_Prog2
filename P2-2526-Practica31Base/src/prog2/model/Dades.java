package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades, Serializable {
    private LlistaExemplars llistaExemplars;
    private LlistaUsuaris llistaUsuaris;
    private LlistaPrestecs llistaPrestecs;
    public Dades(){
        llistaExemplars = new LlistaExemplars();
        llistaPrestecs = new LlistaPrestecs();
        llistaUsuaris = new LlistaUsuaris();
    }
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        Exemplar e = new Exemplar(id, titol, autor, admetPrestecLlarg);
        llistaExemplars.afegir(e);
    }

    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        ArrayList<Exemplar> llistaE = llistaExemplars.getArrayList();
        return llistaE;
    }

    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        Usuari u = null;
        if(esEstudiant)  u = new Estudiant(email,nom, adreca);
        else u = new Professor(email, nom, adreca);
        llistaUsuaris.afegir(u);

    }

    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        ArrayList<Usuari> llistaU = llistaUsuaris.getArrayList();
        return llistaU;
    }

    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        Usuari u = llistaUsuaris.getAt(usuariPos);
        Exemplar e = llistaExemplars.getAt(exemplarPos);
        Date date = new Date();
        Prestec p = null;
        if(esLlarg) p = new PrestecLlarg(e, u ,date);
        else p = new PrestecNormal(e, u, date);
        llistaPrestecs.afegir(p);
    }

    @Override
    public void retornarPrestec(int position) throws BiblioException {
        Prestec p = llistaPrestecs.getAt(position);
        p.retorna();

    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        ArrayList<Prestec> llistaP = llistaPrestecs.getArrayList();
        return llistaP;
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> lP = recuperaPrestecs();
        ArrayList<Prestec> noRetornats = new ArrayList<>();
        Iterator<Prestec> it = lP.iterator();
        while(it.hasNext()){
            Prestec e= it.next();
            if(!e.getRetornat()) noRetornats.add(e);
        }

        return noRetornats;
    }
}

package prog2.adaptador;

import prog2.model.*;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Adaptador {
    private Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }

    public void guardaDades(String camiDesti) throws BiblioException {
        File file = new File(camiDesti);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            System.out.println("Dades guardades correctament");
        } catch(IOException e){
            throw new BiblioException("No s'han pogut guardar les dades");

        }
        finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException e) {
                throw new BiblioException("No s'ha pogut tancar el fitxer");
            }
        }
    }

    public void carregaDades(String camiOrigen) throws BiblioException {
        File file = new File(camiOrigen);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            this.dades = (Dades) ois.readObject();

        } catch(Exception e){
            throw new BiblioException("No s'han pogut recuperar les dades");
        }
        finally{
            try{
                fis.close();
                ois.close();
            } catch(Exception e){
                throw new BiblioException("No s'ha pogut tancar el fitxer");
            }
        }
    }
    public List<String> toStringLlistaExemplars() {
        ArrayList<Exemplar> le = dades.recuperaExemplars();
        List<String> lines = new ArrayList<String>();
        Iterator<Exemplar> it = le.iterator();

        while (it.hasNext()) {
            Exemplar e = it.next();
            lines.add(e.toString());
        }

        return lines;
    }

    public List<String> toStringLlistaUsuaris() {
        ArrayList<Usuari> lu = dades.recuperaUsuaris();
        List<String> lines = new ArrayList<String>();
        Iterator<Usuari> it = lu.iterator();

        while (it.hasNext()) {
            Usuari u = it.next();
            lines.add(u.toString());
        }

        return lines;
    }

    public List<String> toStringLlistaPrestecs() {
        ArrayList<Prestec> lp = dades.recuperaPrestecs();
        List<String> lines = new ArrayList<String>();
        Iterator<Prestec> it = lp.iterator();

        while (it.hasNext()) {
            Prestec p = it.next();
            lines.add(p.toString());
        }

        return lines;
    }

    public List<String> toStringLlistaPrestecsNoRetornats() {
        ArrayList<Prestec> lp = dades.recuperaPrestecs();
        List<String> lines = new ArrayList<String>();
        Iterator<Prestec> it = lp.iterator();

        while (it.hasNext()) {
            Prestec p = it.next();

            if (!p.getRetornat())
                lines.add(p.toString());
        }

        return lines;
    }

    public void afegirExemplar(String id, String autor, String titol, boolean admetPrestecLlarg) {
        dades.afegirExemplar(id, autor, titol, admetPrestecLlarg);
    }

    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    public void afegirPrestec(String email, String id, boolean tipus) throws BiblioException{
        int exemplarPos = 0, usuariPos = 0;
        boolean trobat = false;
        ArrayList<Exemplar> le = dades.recuperaExemplars();
        ArrayList<Usuari> lu = dades.recuperaUsuaris();
        Iterator<Exemplar> ite = le.iterator();
        Iterator<Usuari> itu = lu.iterator();

        while (ite.hasNext() && !trobat) {
            Exemplar e = ite.next();

            if (e.getId().equals(id)) {
                trobat = true;
            } else exemplarPos ++;
        }

        if (!trobat) {
            throw new BiblioException("L'ID introduït és incorrecte");
        } else trobat = false;

        while (itu.hasNext() && !trobat) {
            Usuari u = itu.next();

            if (u.getEmail().equals(email)) {
                trobat = true;
            } else usuariPos ++;
        }

        if (!trobat)
            throw new BiblioException("L'email introduït és incorrecte");

        dades.afegirPrestec(exemplarPos, usuariPos, tipus);
    }

    public void retornarPrestec(String id) {
        int position = 0;
        boolean trobat = false;
        ArrayList<Prestec> lp = dades.recuperaPrestecs();
        Iterator<Prestec> it = lp.iterator();

        while (it.hasNext() && !trobat) {
            Prestec p = it.next();

            if (p.getExemplar().getId().equals(id)) {
                trobat = true;
            } else position++;
        }

        if (!trobat)
            throw new BiblioException("L'ID introduït és incorrecte");

        dades.retornarPrestec(position);
    }
}

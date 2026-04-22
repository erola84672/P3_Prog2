package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaPrestecs extends Llista<Prestec> {
    public LlistaPrestecs(){
        super();
    }

    @Override
    public void afegir(Prestec prestec) throws BiblioException {
        Exemplar e = prestec.getExemplar();
        if (!e.isDisponible())
            throw new BiblioException("Aquest exemplar no està disponible");

        Usuari u = prestec.getUsuari();
        ArrayList<Prestec> llistaP = getArrayList();
        Iterator<Prestec> it = llistaP.iterator();

        while (it.hasNext()) {
            Prestec p = it.next();
            Usuari posUsuari = p.getUsuari();

            if (posUsuari.getEmail().equals(u.getEmail())) {
                if (p.prestecEndarrerit())
                    throw new BiblioException("Aquest usuari té un préstec endarrerit");
            }
        }

        if (prestec instanceof PrestecLlarg) {
            if (!e.getAdmetPrestecLlarg())
                throw new BiblioException("Aquest exemplar no admet préstecs llargs");

            if (u.getNumPrestecsLlargs() >= u.getMaxPrestecsLlargs())
                throw new BiblioException("Aquest usuari no pot demanar meś préstecs " + prestec.tipusPrestec());
            else u.setNumPrestecsLlargs(u.getNumPrestecsLlargs() + 1);
        } else if (prestec instanceof PrestecNormal) {
            if (u.getNumPrestecsNormals() >= u.getMaxPrestecsNormals())
                throw new BiblioException("Aquest usuari no pot demanar meś préstecs " + prestec.tipusPrestec());
            else u.setNumPrestecsNormals(u.getNumPrestecsNormals() + 1);
        }
        llista.add(prestec);
        prestec.getExemplar().setDisponible(false);
    }
}

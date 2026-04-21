package prog2.model;

import prog2.vista.BiblioException;

import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> {
    public LlistaExemplars() {
        super();
    }

    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {
        Iterator<Exemplar> it = llista.iterator();

        while (it.hasNext()) {
            Exemplar e = it.next();
            if (e.getId().equals(exemplar.getId())) {
                throw new BiblioException("L'exemplar ja és a la llista");
            }
        }
    }
}

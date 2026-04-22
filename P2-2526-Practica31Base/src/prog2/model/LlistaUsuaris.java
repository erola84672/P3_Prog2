package prog2.model;

import prog2.vista.BiblioException;

import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> {
    public LlistaUsuaris() {
            super();
        }
        @Override
        public void afegir(Usuari usuari) throws BiblioException {
            Iterator<Usuari> it = llista.iterator();

            while (it.hasNext()) {
                Usuari u = it.next();
                if (u.getEmail().equals(usuari.getEmail())) {
                    throw new BiblioException("L'usuari ja és a la llista");
                }
            }
            llista.add(usuari);
    }

    public boolean contains(String email) {
        Iterator<Usuari> it = llista.iterator();
        boolean trobat = false;

        while (it.hasNext() && !trobat) {
            Usuari e = it.next();
            if (e.getEmail().equals(email)) {
                trobat = true;
            }
        }
        return trobat;
    }
}


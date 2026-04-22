package prog2.adaptador;

import prog2.model.Dades;
import prog2.vista.BiblioException;

import java.io.*;

public class Adaptador {
    private Dades dades;

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
            throw new BiblioException("Error guardant les dades");

        }
        finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException e) {
                throw new BiblioException("Error tancant el fitxer");
            }
        }
    }

    public void carregaDades(String camiOrigen) throws BiblioException {
        File file = new File(camiOrigen);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Dades dades2 = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            dades2 = (Dades) ois.readObject();

        } catch(Exception e){
            throw new BiblioException("No s'han pogut recuperar les dades");
        }
        finally{
            try{
                fis.close();
                ois.close();
            } catch(Exception e){
                throw new BiblioException("No s'han pogut recuperar les dades");
            }
        }
        this.dades = dades2;
        // tenim problemes perquè volem que retorni i no retorna
    }
}

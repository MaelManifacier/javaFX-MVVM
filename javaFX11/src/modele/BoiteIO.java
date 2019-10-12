package modele;

import java.io.*;

public class BoiteIO {

    public static Boite load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("boite.bin"))){
            return (Boite) os.readObject();
        }
    }

    public static void sauvegarder(Boite boite) throws IOException {
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("boite.bin"))){
            os.writeObject(boite);
        }
    }

}

package modele;

import java.io.*;

public class EleveurIO {

    private Eleveur eleveur;

    public EleveurIO() {
        this.eleveur = null;
    }

    public EleveurIO(Eleveur eleveur) {
        this.eleveur = eleveur;
    }

    public static Eleveur load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("eleveur.txt"))){
            return (Eleveur) os.readObject();
        }
    }

    public void sauver(Eleveur eleveur) throws IOException {
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("eleveur.txt"))){
            os.writeObject(eleveur);
        }
    }
}

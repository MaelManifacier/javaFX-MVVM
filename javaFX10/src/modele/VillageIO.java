package modele;

import java.io.*;

public class VillageIO {

    public static Village load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("village.txt"))){
            return (Village) os.readObject();
        }
    }

    public void sauver(Village village) throws IOException {
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("village.txt"))){
            os.writeObject(village);
        }
    }
}

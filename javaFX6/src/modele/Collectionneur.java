package modele;

import java.util.List;

public class Collectionneur {

    private List<Papillon> listePapillons;

    public Collectionneur(){

    }

    public void ajouterPapillon(Papillon p){
        this.listePapillons.add(p);
    }
}

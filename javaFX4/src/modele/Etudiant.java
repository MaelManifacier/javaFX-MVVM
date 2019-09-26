package modele;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Etudiant {

    private StringProperty nom = new SimpleStringProperty();
    public StringProperty nomProperty() { return nom; }
    public String getNom() { return nom.get(); }
    public void setNom(String nom) { this.nom.set(nom); }

    public Etudiant(String nom){setNom(nom);}

    @Override
    public String toString(){
        return getNom();
    }
}

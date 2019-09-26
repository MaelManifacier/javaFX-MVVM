package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lapin {

    private StringProperty nom = new SimpleStringProperty();
        public StringProperty nomProperty() {return nom;}
        public String getNom() {return nom.getValue();}
        public void setNom (String nom) {this.nom.setValue(nom);}


    private StringProperty couleur = new SimpleStringProperty();
        public StringProperty couleurProperty() {return couleur;}
        public String getCouleur() { return couleur.get(); }
        public void setCouleur(String couleur) { this.couleur.set(couleur); }


    private BooleanProperty isLapinGarou = new SimpleBooleanProperty();
        public BooleanProperty isLapinGarouProperty() { return isLapinGarou; }
        public boolean isIsLapinGarou() { return isLapinGarou.get(); }
        public void setIsLapinGarou(boolean isLapinGarou) { this.isLapinGarou.set(isLapinGarou); }


    public Lapin(String nom, String couleur){
        setNom(nom);
        setCouleur(couleur);
    }

    @Override
    public String toString(){
            return this.getNom();
    }

}

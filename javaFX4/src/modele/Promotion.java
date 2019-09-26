package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Promotion {

    private ObservableList<Etudiant> laPromoData = FXCollections.observableArrayList();

    private ListProperty<Etudiant> listeEtudiants = new SimpleListProperty<>(laPromoData);
    public ListProperty<Etudiant> listeEtudiantsProperty() { return listeEtudiants; }
    public ObservableList<Etudiant> getListeEtudiants() { return listeEtudiants.get(); }
    public void setListeEtudiants(ObservableList<Etudiant> listeEtudiants) { this.listeEtudiants.set(listeEtudiants); }

    public Promotion(){}
}

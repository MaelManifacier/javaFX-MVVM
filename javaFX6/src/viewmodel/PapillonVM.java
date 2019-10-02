package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import modele.Papillon;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PapillonVM {

    private Papillon papillon;

    private PropertyChangeListener listener;

    private StringProperty nom = new SimpleStringProperty();
    public StringProperty nomProperty() { return nom; }
    public String getNom() { return nom.get(); }
    public void setNom(String nom) {
        this.nom.set(nom);
    }


    private ObservableList<String> listeCouleursData = FXCollections.observableArrayList();

    private ListProperty<String> listeCouleurs = new SimpleListProperty<>(listeCouleursData);
    public ListProperty<String> listeCouleursProperty() { return listeCouleurs; }
    public ObservableList<String> getListeCouleurs() { return listeCouleurs.get(); }
    public void setListeCouleurs(ObservableList<String> listeCouleurs) {
        this.listeCouleurs.set(listeCouleurs);
    }

    public PapillonVM(String nom){
        this.papillon = new Papillon(nom);
        setNom(nom);
        this.listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                if(propertyChangeEvent.getPropertyName().equals("nom")){
                    setNom((String) propertyChangeEvent.getNewValue());
                }
                if(propertyChangeEvent.getPropertyName().equals("listeCouleurs")){
                    setListeCouleurs((ObservableList<String>) propertyChangeEvent.getNewValue());
                }
            }
        };

        this.nom.addListener((__, old, newValue) -> {
            if(newValue != null){
                this.papillon.setNom(newValue);
            }
        });
    }

    @Override
    public String toString(){
        return getNom()+" VM";
    }

}

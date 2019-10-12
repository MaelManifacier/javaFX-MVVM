package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Souris;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SourisVM implements PropertyChangeListener{

    private Souris model;

    private StringProperty nom = new SimpleStringProperty();
        public StringProperty nomProperty() { return nom; }
        public String getNom() { return nom.get(); }
        public void setNom(String nom) { this.nom.set(nom); }

    public SourisVM(Souris model) {
        this.model = model;
        this.model.addListener(this);
        setNom(model.getNom());
        nom.addListener((__, old, newValue) -> {
            if(newValue != null){
                model.setNom(newValue);
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if(propertyChangeEvent.getPropertyName().equals(Souris.SOURIS)){
            if(propertyChangeEvent.getNewValue() != null){
                setNom((String)propertyChangeEvent.getNewValue());
            }
        }
    }
}

package modele;

import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Ingredient implements Serializable {

    public static final String NOMINGREDIENT = "nbfxd";
    private transient PropertyChangeSupport support;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String old = this.nom;
        this.nom = nom;
        this.getSupport().firePropertyChange(NOMINGREDIENT, old, nom);
    }

    public Ingredient(String nom){
        this.support = new PropertyChangeSupport(this);
        setNom(nom);
    }

    public void addListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        this.getSupport().removePropertyChangeListener(listener);
    }

    private PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }
        return this.support;
    }
}

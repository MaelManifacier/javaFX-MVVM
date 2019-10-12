package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Souris implements Serializable {

    public static String SOURIS = "bngfdsq";
    private transient PropertyChangeSupport support;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        support.firePropertyChange(SOURIS, this.nom, nom);
        this.nom = nom;
    }

    public Souris(String nom) {
        this.support = new PropertyChangeSupport(this);
        setNom(nom);
    }

    public void addListener(PropertyChangeListener listener){
        this.support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        this.support.removePropertyChangeListener(listener);
    }
}

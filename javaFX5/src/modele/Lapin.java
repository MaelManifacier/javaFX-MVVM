package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Lapin implements Serializable {

    private static final String NOM="lapin";

    private String nom;

    private PropertyChangeSupport support;

    public Lapin(String nom) {
        support = new PropertyChangeSupport(this);
        this.nom = nom;
    }

    public void addObserver(PropertyChangeListener listener){
        this.support.addPropertyChangeListener(listener);
    }

    public void removeObserver(PropertyChangeListener listener){
        this.support.removePropertyChangeListener(listener);
    }

    public void setNom(String nom){
        this.support.firePropertyChange(NOM, this.nom, nom);
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    @Override
    public String toString(){
        return getNom();
    }
}

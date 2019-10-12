package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Eleveur implements Serializable {

    public static String LISTE = "jrqe";
    private transient PropertyChangeSupport support;

    private List<Souris> listeSouris;

    public Eleveur() {
        this.listeSouris = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public List<Souris> getListeSouris() {
        return listeSouris;
    }

    public void addSouris(Souris souris) {
        this.listeSouris.add(souris);
        this.support.fireIndexedPropertyChange(LISTE, this.listeSouris.size()-1, null, souris);
    }

    public void addObserver(PropertyChangeListener listener){
        this.support.addPropertyChangeListener(listener);
    }

    public void removeObserver(PropertyChangeListener listener){
        this.support.removePropertyChangeListener(listener);
    }

}

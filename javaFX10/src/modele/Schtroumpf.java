package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Schtroumpf implements Serializable {

    public static final String CARACTERE = "hgfds";
    public static final String LISTAVENTURE = "jhgfd";
    private transient PropertyChangeSupport support;
    private String caractere;

    private List<Aventure> listeAventures;

    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
        this.getSupport().firePropertyChange(CARACTERE, this.caractere, caractere);
        this.caractere = caractere;
    }

    public Schtroumpf(String caractere) {
        setCaractere(caractere);
        this.listeAventures = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public List<Aventure> getListAventures() {
        return listeAventures;
    }

    public void ajouterAventure(Aventure aventure){
        this.listeAventures.add(aventure);
        this.getSupport().fireIndexedPropertyChange(LISTAVENTURE, this.listeAventures.size()-1, null, aventure);
    }

    public void addListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        this.getSupport().removePropertyChangeListener(listener);
    }

    public PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }
        return this.support;
    }
}

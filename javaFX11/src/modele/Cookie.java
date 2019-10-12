package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cookie implements Serializable {

    public static final String TYPECOOKIE = "nhgfds";
    public static final String LISTINGREDIENT = "hgfds";
    private transient PropertyChangeSupport support;

    private String type;
    private List<Ingredient> listeIngredients;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String old = this.type;
        this.type = type;
        this.getSupport().firePropertyChange(TYPECOOKIE, old, type);
    }

    public List<Ingredient> getListeIngredients() {
        return listeIngredients;
    }

    public void ajouterIngredient(Ingredient ingredient){
        this.listeIngredients.add(ingredient);
        this.getSupport().fireIndexedPropertyChange(LISTINGREDIENT, this.listeIngredients.size()-1, null, ingredient);
    }

    public Cookie(String type){
        this.support = new PropertyChangeSupport(this);
        this.listeIngredients = new ArrayList<>();
        setType(type);
    }

    public void ajouterListener(PropertyChangeListener listener){
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

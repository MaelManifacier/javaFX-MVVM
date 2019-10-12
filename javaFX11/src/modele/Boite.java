package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Boite implements Serializable {

    public static final String LISTCOOKIE = "osef";
    private transient PropertyChangeSupport support;

    private List<Cookie> listeCookies;

    public List<Cookie> getListeCookies() {
        return listeCookies;
    }

    public void ajouterCookie(Cookie cookie){
        this.listeCookies.add(cookie);
        this.getSupport().fireIndexedPropertyChange(LISTCOOKIE, this.listeCookies.size()-1, null, cookie);
    }

    public Boite(){
        this.support = new PropertyChangeSupport(this);
        this.listeCookies = new ArrayList<>();
    }

    public void ajouterListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        this.getSupport().removePropertyChangeListener(listener);
    }

    public void ajouterIngredient(int index, String ingredient) {
        Cookie cookie = this.listeCookies.get(index);
        if(cookie != null){
            cookie.ajouterIngredient(new Ingredient(ingredient));
        }
    }

    private PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }
        return this.support;
    }
}

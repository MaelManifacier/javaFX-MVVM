package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Aventure implements Serializable {

    public static String THEME = "hgqr";
    private transient PropertyChangeSupport support;

    private String theme;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        String oldTheme = this.theme;
        this.theme = theme;
        this.getSupport().firePropertyChange(THEME, oldTheme, theme);
    }

    public Aventure(String theme) {
        setTheme(theme);
        this.support = new PropertyChangeSupport(this);
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

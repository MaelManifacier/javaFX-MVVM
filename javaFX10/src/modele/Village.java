package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Village implements Serializable {

    public static final String LIST = "yhrs";
    private transient PropertyChangeSupport support;

    private List<Schtroumpf> listeSchtroumpf;

    public List<Schtroumpf> getListSchtroumpf() {
        return listeSchtroumpf;
    }

    public Village() {
        this.listeSchtroumpf = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public void ajouterSchtroumpf(Schtroumpf schtroumpf){
        this.listeSchtroumpf.add(schtroumpf);
        this.getSupport().fireIndexedPropertyChange(LIST, this.listeSchtroumpf.size()-1, null, schtroumpf);
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

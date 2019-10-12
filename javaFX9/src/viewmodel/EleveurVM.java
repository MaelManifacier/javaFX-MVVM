package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Eleveur;
import modele.EleveurIO;
import modele.Souris;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class EleveurVM implements PropertyChangeListener{

    private Eleveur model;

    private ObservableList<SourisVM> listeSourisData = FXCollections.observableArrayList();
    private ListProperty<SourisVM> listeSouris = new SimpleListProperty<>(listeSourisData);
        public ListProperty<SourisVM> listeSourisProperty() { return listeSouris; }
        public ObservableList<SourisVM> getListeSouris() { return listeSouris.get(); }
        public void setListeSouris(ObservableList<SourisVM> listeSouris) { this.listeSouris.set(listeSouris); }

    public EleveurVM() {
        this.model = new Eleveur();
        model.addObserver(this);
    }

    public void addSouris(String nom){
            model.addSouris(new Souris(nom));
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if(propertyChangeEvent.getPropertyName().equals(Eleveur.LISTE)){
            if(propertyChangeEvent.getNewValue() != null){
                //listeSourisData.add(((IndexedPropertyChangeEvent)propertyChangeEvent).getIndex(),(SourisVM) propertyChangeEvent.getNewValue());
                listeSourisData.add( new SourisVM ((Souris) propertyChangeEvent.getNewValue()));
            }
        }
    }

    public void sauvegarder() {
        EleveurIO eleveurIO = new EleveurIO();
        try {
            eleveurIO.sauver(this.model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

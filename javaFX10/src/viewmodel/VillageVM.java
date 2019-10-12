package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import launch.Launch;
import modele.Aventure;
import modele.Schtroumpf;
import modele.Village;
import modele.VillageIO;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class VillageVM implements PropertyChangeListener {

    private Village village;

    private ObservableList<SchtroumpfVM> listeSchtroumpfsData = FXCollections.observableArrayList();

    private ListProperty<SchtroumpfVM> listeSchtroumpfs = new SimpleListProperty<>(listeSchtroumpfsData);
    public ListProperty<SchtroumpfVM> listeSchtroumpfsProperty() { return listeSchtroumpfs; }
    public ObservableList<SchtroumpfVM> getListeSchtroumpfs() { return listeSchtroumpfs.get(); }
    public void setListeSchtroumpfs(ObservableList<SchtroumpfVM> listeSchtroumpfs) { this.listeSchtroumpfs.set(listeSchtroumpfs); }


    public VillageVM(){


        try {
            this.village = VillageIO.load();
            if(this.village == null){
                this.village = new Village();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.village.addListener(this);

        this.village.getListSchtroumpf().forEach(schtroumpf -> {
            this.listeSchtroumpfsData.add(new SchtroumpfVM(schtroumpf));
        });
    }

    public void ajouterSchtroumpf(String caractere){
        this.village.ajouterSchtroumpf(new Schtroumpf(caractere));
    }

    public void ajouterAventure(String theme, int schtroumpfIndex){
        SchtroumpfVM schtroumpfVM = this.getListeSchtroumpfs().get(schtroumpfIndex);
        if(schtroumpfVM != null){
            schtroumpfVM.ajouterAventure(theme);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals(Village.LIST)){
            if(propertyChangeEvent.getNewValue() != null){
                this.listeSchtroumpfsData.add( ((IndexedPropertyChangeEvent)propertyChangeEvent).getIndex(), new SchtroumpfVM((Schtroumpf) propertyChangeEvent.getNewValue()));
            }
        }
    }

    public void sauver() {
        VillageIO villageIO = new VillageIO();
        try {
            villageIO.sauver(this.village);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

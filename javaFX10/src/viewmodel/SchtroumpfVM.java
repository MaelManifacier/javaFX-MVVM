package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Aventure;
import modele.Schtroumpf;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SchtroumpfVM implements PropertyChangeListener {

    private Schtroumpf modele;

    private StringProperty caractere = new SimpleStringProperty();
        public StringProperty caractereProperty() { return caractere; }
        public String getCaractere() { return caractere.get(); }
        public void setCaractere(String caractere) { this.caractere.set(caractere); }



    private ObservableList<AventureVM> listeAventureData = FXCollections.observableArrayList();

    private ListProperty<AventureVM> listeAventure = new SimpleListProperty<>(listeAventureData);
        public ListProperty<AventureVM> listeAventureProperty() { return listeAventure; }
        public ObservableList<AventureVM> getListeAventure() { return listeAventure.get(); }


    public SchtroumpfVM(Schtroumpf schtroumpf){
        this.modele = schtroumpf;
        this.modele.addListener(this);
        setCaractere(schtroumpf.getCaractere());
        this.modele.getListAventures().forEach(aventure -> {
            this.listeAventureData.add(new AventureVM(aventure));
        });

        this.caractere.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null){
                    modele.setCaractere(newValue);
                }
            }
        });
    }


    public void ajouterAventure(String theme){
            this.modele.ajouterAventure(new Aventure(theme));
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if(propertyChangeEvent.getPropertyName().equals(Schtroumpf.CARACTERE)){
            if(propertyChangeEvent.getNewValue() != null){
                setCaractere( (String) propertyChangeEvent.getNewValue());
            }
        }
        if(propertyChangeEvent.getPropertyName().equals(Schtroumpf.LISTAVENTURE)){
            if(propertyChangeEvent.getNewValue() != null){
                listeAventureData.add( ((IndexedPropertyChangeEvent)propertyChangeEvent).getIndex(), new AventureVM((Aventure) propertyChangeEvent.getNewValue()) );
            }
        }
    }
}

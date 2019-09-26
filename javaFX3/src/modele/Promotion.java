package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Promotion {

    private ObservableList<Lapin> laListeData = FXCollections.observableArrayList();

    private ListProperty<Lapin> laListe = new SimpleListProperty<>(laListeData);
        public ListProperty laListeProperty() {return laListe;}
        public List getLaListe() {return laListe.getValue();}

}

package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionneurVM {

    private ObservableList<PapillonVM> listPapillonData = FXCollections.observableArrayList();


    private ListProperty<PapillonVM> listePapillon = new SimpleListProperty<>(listPapillonData);
    public ListProperty<PapillonVM> listePapillonProperty() { return listePapillon; }
    public ObservableList<PapillonVM> getListePapillon() { return listePapillon.get(); }
    public void setListePapillon(ObservableList<PapillonVM> listePapillon) { this.listePapillon.set(listePapillon); }


}

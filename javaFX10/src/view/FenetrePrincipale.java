package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import viewmodel.*;


public class FenetrePrincipale {

    @FXML
    ListView<SchtroumpfVM> listeSchtroumpfs;

    @FXML
    Label caractereSchtroumpf;

    @FXML
    ListView<AventureVM> listeAventures;

    @FXML
    TextField changerCaractere;

    @FXML
    Label themeAventure;

    @FXML
    TextField changerTheme;

    private VillageVM villageVM = new VillageVM();


    public void initialize(){
        this.listeSchtroumpfs.itemsProperty().bind(villageVM.listeSchtroumpfsProperty());

        this.listeSchtroumpfs.getSelectionModel().selectedItemProperty().addListener((__, old, newV) -> {
            if(old != null){
                changerCaractere.textProperty().unbindBidirectional(old.caractereProperty());
            }
            if(newV != null){
                caractereSchtroumpf.textProperty().bind(newV.caractereProperty());
                changerCaractere.textProperty().bindBidirectional(newV.caractereProperty());
                listeAventures.itemsProperty().bind(newV.listeAventureProperty());
            }
        });

        this.listeSchtroumpfs.setCellFactory(new Callback<ListView<SchtroumpfVM>, ListCell<SchtroumpfVM>>() {
            @Override
            public ListCell<SchtroumpfVM> call(ListView<SchtroumpfVM> param) {
                return new CellListSchtroumpf();
            }
        });

        this.listeAventures.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AventureVM>() {
            @Override
            public void changed(ObservableValue<? extends AventureVM> observable, AventureVM oldValue, AventureVM newValue) {
                if(oldValue != null){
                    changerTheme.textProperty().unbindBidirectional(oldValue.themeProperty());
                }
                if(newValue!= null){
                    themeAventure.textProperty().bind(newValue.themeProperty());
                    changerTheme.textProperty().bindBidirectional(newValue.themeProperty());
                }
            }
        });

        this.listeAventures.setCellFactory(new Callback<ListView<AventureVM>, ListCell<AventureVM>>() {
            @Override
            public ListCell<AventureVM> call(ListView<AventureVM> param) {
                return new CellListAventure();
            }
        });
    }

    public void ajouterSchtroumpf() {
        this.villageVM.ajouterSchtroumpf("-- Un Schtroumpf --");
    }

    public void ajouterAventure(ActionEvent actionEvent) {
        this.villageVM.ajouterAventure("-- Aventure --", listeSchtroumpfs.getSelectionModel().getSelectedIndex());
    }

    public void sauver() {
        this.villageVM.sauver();
    }
}

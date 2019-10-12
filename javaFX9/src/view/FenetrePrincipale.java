package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import viewmodel.EleveurVM;
import viewmodel.MaCell;
import viewmodel.SourisVM;

public class FenetrePrincipale {

    @FXML
    ListView<SourisVM> listeSouris;
    @FXML
    Label nomSouris;
    @FXML
    TextField changerNomSouris;

    private EleveurVM eleveurVM = new EleveurVM();


    public FenetrePrincipale(EleveurVM eleveurVM) {
        if(eleveurVM != null){
            this.eleveurVM = eleveurVM;
        }
    }

    public void initialize(){
        listeSouris.itemsProperty().bind(eleveurVM.listeSourisProperty());

        listeSouris.setCellFactory(new Callback<ListView<SourisVM>, ListCell<SourisVM>>() {
            @Override
            public ListCell<SourisVM> call(ListView<SourisVM> param) {
                return new MaCell();
            }
        });

        listeSouris.getSelectionModel().selectedItemProperty().addListener((__, old, newValue)->{
            if(old != null){
                changerNomSouris.textProperty().unbindBidirectional(old.nomProperty());
            }
            if(newValue != null){
                nomSouris.textProperty().bind(newValue.nomProperty());
                changerNomSouris.textProperty().bindBidirectional(newValue.nomProperty());
            }
        });

        this.eleveurVM.addSouris("HEY");
    }

    public void ajouterSouris(ActionEvent actionEvent) {
        eleveurVM.addSouris("-- une souris --");
    }

    public void sauvegarder(){
        this.eleveurVM.sauvegarder();
    }
}

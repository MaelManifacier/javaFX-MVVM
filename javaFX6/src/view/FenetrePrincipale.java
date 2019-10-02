package view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import viewmodel.CollectionneurVM;
import viewmodel.PapillonVM;

public class FenetrePrincipale {

    @FXML
    ColorPicker couleur;

    @FXML
    ListView<PapillonVM> listePapillon;

    @FXML
    ListView<String> listeCouleurs;

    @FXML
    Label nompapillon;

    private PapillonVM papillonVM;

    private CollectionneurVM collectionneurVM;

    public void initialize(){

        this.collectionneurVM = new CollectionneurVM();
        createPapillonVM(); //besoin de créer collectionneur

        listePapillon.itemsProperty().bind(this.collectionneurVM.listePapillonProperty());

        listePapillon.getSelectionModel().selectedItemProperty().addListener((__, old, newV) -> {
            if(newV != null){
                nompapillon.textProperty().bind(newV.nomProperty());
                listeCouleurs.itemsProperty().bind(newV.listeCouleursProperty());
            }
        });
    }

    private void createPapillonVM(){
        PapillonVM papillonVM = new PapillonVM("Un autre papillon");
        papillonVM.getListeCouleurs().add("bleu");
        papillonVM.getListeCouleurs().add("blanc");
        papillonVM.getListeCouleurs().add("rouge");
        this.collectionneurVM.getListePapillon().add(papillonVM);
    }

    public void ajouterPapillon(){
        collectionneurVM.getListePapillon().add(new PapillonVM("-- Papillon --"));
    }

    public void quitterApp(){
        launch.Launch.fermerApp();
    }
}

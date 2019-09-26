package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import modele.Lapin;
import modele.Promotion;

public class FenetrePrincipale {

    @FXML
    ListView<Lapin> laListeView;

    @FXML
    ListView<Lapin> laListeView2;

    @FXML
    TextField textFieldChangementNom;

    @FXML
    TextField textFieldChangementCouleur;

    @FXML
    Label labelAffichageNom;

    @FXML
    Label labelAffichageCouleur;

    @FXML
    Label cbIsLapinGarou;

    private Promotion laPromotion = new Promotion();

    public void initialize(){
        createLapin();
        laListeView.itemsProperty().bind(laPromotion.laListeProperty());

        laListeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Lapin>() {
            @Override
            public void changed(ObservableValue observableValue, Lapin o, Lapin t1) {
                if(o != null){
                    textFieldChangementNom.textProperty().unbindBidirectional(o.nomProperty());
                    textFieldChangementCouleur.textProperty().unbindBidirectional(o.couleurProperty());
                }
                if(t1 != null){
                    labelAffichageNom.textProperty().bind(t1.nomProperty());
                    labelAffichageCouleur.textProperty().bind(t1.couleurProperty());
                    textFieldChangementNom.textProperty().bindBidirectional(t1.nomProperty());
                    textFieldChangementCouleur.textProperty().bindBidirectional(t1.couleurProperty());
                    cbIsLapinGarou.textProperty().bind(t1.isLapinGarouProperty().asString());
                }
            }
        });

        laListeView.setCellFactory(new Callback<ListView<Lapin>, ListCell<Lapin>>() {
            @Override
            public ListCell<Lapin> call(ListView<Lapin> param) {
                return new CelluleListe();
            }
        });

        laListeView2.itemsProperty().bind(laListeView.itemsProperty());
        laListeView2.selectionModelProperty().bind(laListeView.selectionModelProperty());

    }

    public void ajouterLapin(){
        this.laPromotion.getLaListe().add(new Lapin("unLapinblanc!", "blanc"));
    }


    public void createLapin(){
        this.laPromotion.getLaListe().add(new Lapin("Wallace", "blanc"));
        this.laPromotion.getLaListe().add(new Lapin("you", "noir"));
        this.laPromotion.getLaListe().add(new Lapin("there", "marron"));
        this.laPromotion.getLaListe().add(new Lapin("Jack Jack", "bariolé"));
    }

}

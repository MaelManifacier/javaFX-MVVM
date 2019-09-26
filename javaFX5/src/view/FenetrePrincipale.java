package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import stub.LapinStub;

public class FenetrePrincipale {

    @FXML
    TextField textFieldNomLapin;

    @FXML
    Label labelNomLapin;

    @FXML
    Label labelNomLapinRecupere;

    @FXML
    Label messageErreur;

    private LapinStub stub = new LapinStub();

    public void initialize() {
        textFieldNomLapin.textProperty().bindBidirectional(this.stub.lapinVM.nomProperty());
        labelNomLapin.textProperty().bind(stub.lapinVM.nomProperty());
    }

    public void sauvegarder(){
        String message = stub.lapinVM.sauvegarder();
        if(!message.equals("")){
            this.messageErreur.setText(message);
        }
    }

    public void recuperer(){
        String nom = stub.lapinVM.recuperer();
        if(nom != null){
            labelNomLapinRecupere.setText(nom);
        } else {
            labelNomLapinRecupere.setText("Probleme a la recuperation");
        }
    }
}

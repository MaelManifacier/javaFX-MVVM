package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modele.Etudiant;
import modele.Promotion;

public class FenetrePrincipale {

    private Promotion promotion = new Promotion();

    @FXML
    ListView<Etudiant> listeViewPromotion;

    @FXML
    ListView<Etudiant> listViewPromotion2;

    public void initialize(){
        createEtudiant();

        listeViewPromotion.itemsProperty().bind(promotion.listeEtudiantsProperty());

        //listViewPromotion2.selectionModelProperty().bind(listeViewPromotion.selectionModelProperty());

    }

    private void createEtudiant(){
        promotion.getListeEtudiants().add(new Etudiant("Jack Jack"));
    }


    public void ajouterEtudiant(){
        promotion.getListeEtudiants().add(new Etudiant("-- Etudiant --"));
    }
}

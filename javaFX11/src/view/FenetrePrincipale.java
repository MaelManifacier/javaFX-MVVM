package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import viewmodel.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FenetrePrincipale implements Initializable {

    @FXML
    ListView<CookieVM> listeCookies;
    @FXML
    ListView<IngredientVM> listeIngredients;

    @FXML
    Label typeCookie;
    @FXML
    Label nomIngredient;

    @FXML
    BorderPane principal;

    private BoiteVM boiteVM = new BoiteVM();


    public void initialize(URL location, ResourceBundle resources){
        listeCookies.itemsProperty().bind(boiteVM.listeCookiesProperty());

        boiteVM.ajouterCookie("-- cookie --");

        listeCookies.getSelectionModel().selectedItemProperty().addListener((__, old, newValue)-> {
            if(newValue != null){
                typeCookie.textProperty().bind(newValue.typeProperty());
                listeIngredients.itemsProperty().bind(newValue.listeIngredientsProperty());
            }
        });

        listeIngredients.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<IngredientVM>() {
            @Override
            public void changed(ObservableValue<? extends IngredientVM> observable, IngredientVM oldValue, IngredientVM newValue) {
                if(newValue != null){
                    nomIngredient.textProperty().bind(newValue.nomProperty());
                }
            }
        });

        listeCookies.setCellFactory(new Callback<ListView<CookieVM>, ListCell<CookieVM>>() {
            @Override
            public ListCell<CookieVM> call(ListView<CookieVM> param) {
                return new MaCellACookie();
            }
        });

        listeIngredients.setCellFactory(new Callback<ListView<IngredientVM>, ListCell<IngredientVM>>() {
            @Override
            public ListCell<IngredientVM> call(ListView<IngredientVM> param) {
                return new MaCellAIngredient();
            }
        });
    }

    public void ajouterIngredient() {
        this.boiteVM.ajouterIngredient(listeCookies.getSelectionModel().getSelectedIndex());
    }

    public void sauvegarder() {
        this.boiteVM.sauvegarder();
    }

    public void openCookie(){
        try {
            BorderPane borderPane = FXMLLoader.load(getClass().getResource("/fxml/FenetreCookie.fxml"));

            principal.getChildren().setAll(borderPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

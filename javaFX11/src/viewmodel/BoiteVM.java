package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Boite;
import modele.BoiteIO;
import modele.Cookie;
import modele.Ingredient;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class BoiteVM implements PropertyChangeListener {


    private Boite modele;

    private ObservableList<CookieVM> listeCookiesData = FXCollections.observableArrayList();

    private ListProperty<CookieVM> listeCookies = new SimpleListProperty<>(listeCookiesData);
        public ListProperty<CookieVM> listeCookiesProperty() { return listeCookies; }
        public ObservableList<CookieVM> getListeCookies() { return listeCookies.get(); }
        public void setListeCookies(ObservableList<CookieVM> listeCookies) { this.listeCookies.set(listeCookies); }



        public BoiteVM(){
            this.modele = new Boite();
            this.modele.ajouterListener(this);

            this.modele.getListeCookies().forEach(cookie -> {
                this.listeCookiesData.add(new CookieVM(cookie));
            });
        }

        public void ajouterCookie(String type){
            /*
            Cookie cookie = new Cookie(cookieVM.getType());
            //ajouter à la liste
            cookieVM.getListeIngredients().forEach(ingredientVM -> {
                cookie.ajouterIngredient(new Ingredient(ingredientVM.getNom()));
            });*/
            this.modele.ajouterCookie(new Cookie(type));
        }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Boite.LISTCOOKIE)){
            if(evt.getNewValue() != null){
                this.listeCookiesData.add( ((IndexedPropertyChangeEvent)evt).getIndex(), new CookieVM((Cookie) evt.getNewValue()));
            }
        }
    }

    public void ajouterIngredient(int index) {
            this.modele.ajouterIngredient(index, "-- ingredient --");
    }

    public void sauvegarder() {
        try {
            BoiteIO.sauvegarder(this.modele);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

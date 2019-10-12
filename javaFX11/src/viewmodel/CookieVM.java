package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Cookie;
import modele.Ingredient;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CookieVM implements PropertyChangeListener {

    private Cookie modele;

    private StringProperty type = new SimpleStringProperty();
    public StringProperty typeProperty() { return type; }
    public String getType() { return type.get(); }
    public void setType(String type) { this.type.set(type); }

    private ObservableList<IngredientVM> listeIngredientsData = FXCollections.observableArrayList();

    private ListProperty<IngredientVM> listeIngredients = new SimpleListProperty<>(listeIngredientsData);
        public ListProperty<IngredientVM> listeIngredientsProperty() { return listeIngredients; }
        public ObservableList<IngredientVM> getListeIngredients() { return listeIngredients.get(); }
        public void setListeIngredients(ObservableList<IngredientVM> listeIngredients) { this.listeIngredients.set(listeIngredients); }

    public CookieVM(Cookie cookie){
            this.modele = cookie;
            setType(cookie.getType());
            cookie.getListeIngredients().forEach(ingredient -> {
                this.listeIngredientsData.add(new IngredientVM(ingredient));
            });
            this.modele.ajouterListener(this);
    }

    public void ajouterIngredient(String nom){
            this.modele.ajouterIngredient(new Ingredient(nom));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Cookie.TYPECOOKIE)){
            if(evt.getNewValue() != null){
                setType((String) evt.getNewValue());
            }
        }
        if(evt.getPropertyName().equals(Cookie.LISTINGREDIENT)){
            if(evt.getNewValue() != null){
                listeIngredientsData.add(((IndexedPropertyChangeEvent)evt).getIndex(), new IngredientVM((Ingredient) evt.getNewValue()));
            }
        }
    }
}

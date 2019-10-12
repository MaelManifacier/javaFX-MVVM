package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Ingredient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class IngredientVM implements PropertyChangeListener {

    private Ingredient model;

    private StringProperty nom = new SimpleStringProperty();
        public StringProperty nomProperty() { return nom; }
        public String getNom() { return nom.get(); }
        public void setNom(String nom) { this.nom.set(nom); }

    public IngredientVM(Ingredient ingredient){
            this.model = ingredient;
            setNom(ingredient.getNom());
            this.model.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Ingredient.NOMINGREDIENT)){
            if(evt.getNewValue() != null){
                setNom((String) evt.getNewValue());
            }
        }
    }
}

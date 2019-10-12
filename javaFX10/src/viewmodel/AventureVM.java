package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Aventure;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AventureVM implements PropertyChangeListener {

    private Aventure model;

    private StringProperty theme = new SimpleStringProperty();
    public StringProperty themeProperty() { return theme; }
    public String getTheme() { return theme.get(); }
    public void setTheme(String theme) { this.theme.set(theme); }

    public AventureVM(Aventure aventure){
        this.model = aventure;
        this.model.addListener(this);
        setTheme(aventure.getTheme());
    }


    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if(propertyChangeEvent.getPropertyName().equals(Aventure.THEME)){
            if(propertyChangeEvent.getNewValue() != null){
                setTheme( (String) propertyChangeEvent.getNewValue());
            }
        }
    }
}

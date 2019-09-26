package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modele.Lapin;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;

public class LapinVM implements PropertyChangeListener {

    private static final String NOM="lapin";

    private Lapin model;

    private StringProperty nom = new SimpleStringProperty();
        public StringProperty nomProperty() { return nom; }
        public String getNom() { return nom.get(); }
        public void setNom(String nom) { this.nom.set(nom); }

    public LapinVM(Lapin l){
        this.model = l;
        setNom(l.getNom());

        this.nom.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null){
                    model.setNom(newValue);
                }
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if(propertyChangeEvent.getNewValue().equals(NOM)){
            setNom( (String) propertyChangeEvent.getNewValue());
        }
    }

    public String sauvegarder(){
        try(ObjectOutputStream aSerializer = new ObjectOutputStream(new FileOutputStream("Lapin.txt"))) {
            aSerializer.writeObject(model);
        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
        return "";
    }

    public String recuperer(){
        try (ObjectInputStream aDeSerializer = new ObjectInputStream(new FileInputStream("Lapin.txt"))) {
             Lapin lapin = (Lapin) aDeSerializer.readObject();
             return lapin.getNom();
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
}

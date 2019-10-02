package modele;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Papillon {

    private final String NOM="bla";
    private PropertyChangeSupport support;
    private String nom;
    private List<String> listeCouleurs;

    public Papillon(String nom){
        this.support = new PropertyChangeSupport(this);
        this.nom = nom;
        this.listeCouleurs = new ArrayList<>();
    }

    public void ajouterCouleur(String c) throws CouleurException {
        if(c != null){
            this.listeCouleurs.add(c);
        } else {
            throw new CouleurException();
        }
    }

    public List<String> getListeCouleurs(){
        return this.listeCouleurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.support.firePropertyChange(NOM, this.nom, nom);
        this.nom = nom;
    }

    @Override
    public String toString(){
        return getNom();
    }
}

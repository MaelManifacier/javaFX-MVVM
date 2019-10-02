package modele;

public class CouleurException extends Exception{


    public CouleurException() {
        super("Cette couleur n'existe pas");
    }
}

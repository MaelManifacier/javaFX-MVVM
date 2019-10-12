package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Eleveur;
import modele.EleveurIO;
import view.FenetrePrincipale;

public class Launch extends Application {

    FenetrePrincipale fenetrePrincipale;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Eleveur eleveur = EleveurIO.load();

        fenetrePrincipale = new FenetrePrincipale(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        loader.setController(fenetrePrincipale);

        Parent p = loader.load();
        Scene scene = new Scene(p);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void stop() throws Exception {
        fenetrePrincipale.sauvegarder();
        super.stop();
    }
}

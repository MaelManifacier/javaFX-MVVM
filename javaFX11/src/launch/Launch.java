package launch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.BoiteIO;
import view.FenetrePrincipale;

public class Launch extends Application {

    FenetrePrincipale fenetrePrincipale;

    @Override
    public void start(Stage primaryStage) throws Exception {

        fenetrePrincipale = new FenetrePrincipale();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        loader.setController(fenetrePrincipale);
        Parent p = loader.load();

        Scene scene = new Scene(p);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        fenetrePrincipale.sauvegarder();
        super.stop();
    }

}

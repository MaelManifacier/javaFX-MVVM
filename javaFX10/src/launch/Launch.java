package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.VillageIO;
import view.FenetrePrincipale;

public class Launch extends Application {

    private FenetrePrincipale fenetrePrincipale;

    @Override
    public void start(Stage primaryStage) throws Exception {

        fenetrePrincipale = new FenetrePrincipale();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        loader.setController(fenetrePrincipale);

        Parent p = loader.load();
        Scene scene = new Scene(p);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        fenetrePrincipale.sauver();
        super.stop();
    }
}

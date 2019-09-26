package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }
}

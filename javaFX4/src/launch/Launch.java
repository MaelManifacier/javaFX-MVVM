package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource("/fxml/FenetrePrincipale.fxml"));
        Scene scene = new Scene(p);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

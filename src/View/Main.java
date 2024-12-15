package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Charge le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SplashScreen.fxml"));
        
        // Configure la scène avec le contenu du fichier FXML
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Gestion Clinique");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}

package hello;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
<<<<<<< HEAD
public void start(Stage primaryStage) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/FactureView.fxml"));
=======
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/SplashScreen.fxml")); // Chemin vers Welcome.fxml
>>>>>>> df2cbfd5dc2c8df2ee3c7a97dd5f445a2787fb20
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Gestion Clinique");
        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace(); // Affiche l'exception complète
    }
}

    public static void main(String[] args) {
        // Lance l'application JavaFX
        launch(args);
    }
}

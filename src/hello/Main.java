package hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/view.fxml")); // Remplacez le chemin par votre fichier FXML
            BorderPane root = loader.load();

            // Définir le titre de la fenêtre
            primaryStage.setTitle("Gestion Clinique");

            // Créer la scène avec le BorderPane chargé
            Scene scene = new Scene(root, 800, 600);  // Vous pouvez ajuster la taille de la scène si nécessaire

            // Ajouter la scène à la fenêtre principale
            primaryStage.setScene(scene);

            // Afficher la fenêtre
            primaryStage.show();
        } catch (Exception e) {
            // Gérer l'exception en cas de problème avec le fichier FXML ou l'initialisation
            System.err.println("Erreur lors du chargement de l'interface utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}

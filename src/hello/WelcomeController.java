package hello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeController {
    @FXML
    private Button btnCommencer; // Ajout de cette déclaration

    @FXML
    private void commencer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello/View.fxml")); // Remplacez par le chemin correct
            Stage stage = (Stage) btnCommencer.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

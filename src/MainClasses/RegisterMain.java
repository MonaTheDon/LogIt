package MainClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class RegisterMain extends Application {

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/pageDesigns/UserRegis.fxml")));
        primaryStage.setTitle("LogIt Registration Page");
        primaryStage.setScene(new Scene(root, 754.0, 565.0));
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);
    }
}

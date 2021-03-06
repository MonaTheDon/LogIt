package MainClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.util.Objects;

public class LoginMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((getClass().getResource("/pageDesigns/Login.fxml")));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 558.4));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
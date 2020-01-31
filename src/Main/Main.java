package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    public static Stage cStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        String fileLoc = "CODE/Login.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fileLoc));
        primaryStage.setTitle("LOGIN");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();

        cStage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

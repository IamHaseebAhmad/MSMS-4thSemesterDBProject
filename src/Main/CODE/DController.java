package Main.CODE;

import Main.CODE.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class DController {

    private ResultSet ProfileData = LoginController.rs;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label topheader, UserName;

    // This will run during opening of this Activity
    @FXML
    public void initialize() throws SQLException {
        String text =  capitalize(ProfileData.getString("user_name"));
        UserName.setText(text);
    }

    @FXML
    private void Products() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Products/Products.fxml"));
        rootPane.getChildren().setAll(pane);
        topheader.setText("PRODUCTS");
    }

    @FXML
    private void Customers() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Customers/Customers.fxml"));
        rootPane.getChildren().setAll(pane);
        topheader.setText("CUSTOMERS");
    }

    @FXML
    private void Payments() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Payments/Payments.fxml"));
        rootPane.getChildren().setAll(pane);
        topheader.setText("PAYMENTS");
    }

    @FXML
    private void Reports() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Reports/Reports.fxml"));
        rootPane.getChildren().setAll(pane);
        topheader.setText("REPORTS");
    }

    @FXML
    private void AboutUs() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("About.fxml"));
        rootPane.getChildren().setAll(pane);
        topheader.setText("ABOUT US");
    }

}

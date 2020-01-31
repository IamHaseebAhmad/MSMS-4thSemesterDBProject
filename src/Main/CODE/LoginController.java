package Main.CODE;

import Main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    static Stage cStage;
    static ResultSet rs;

    public static Connection con;
    public static Statement st;

    @FXML
    private Label errorOutput;

    @FXML
    private TextField userEmail;

    @FXML
    private PasswordField userPassword;

    @FXML
    void ClickedForSignUp() throws FileNotFoundException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login/SignUp.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void LoginUser(){

        String email = userEmail.getText().toLowerCase().trim();
        String password = userPassword.getText().trim();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            st = con.createStatement();

            // Query Pass Here
            String que = "SELECT * FROM USER_";
            rs=st.executeQuery(que);

            while(rs.next()){

                if (rs.getString("user_email").equalsIgnoreCase(email)
                        && rs.getString("user_password").equalsIgnoreCase(password)){

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                    Main.cStage.close();
                }

                if (rs.getString("user_email").equalsIgnoreCase(email)
                        || rs.getString("user_password").equalsIgnoreCase(password)){

                    errorOutput.setText("Wrong Credentials or User Not Found!");
                }
            }
            rs.close();

        }
        catch (Exception ex){
            errorOutput.setText(ex.getMessage());
            System.out.println("Error: " +ex.getMessage());
        }

    }

}

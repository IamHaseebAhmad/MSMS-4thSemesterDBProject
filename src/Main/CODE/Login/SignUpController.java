package Main.CODE.Login;

import Main.CODE.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;

public class SignUpController {

    @FXML
    private TextField su_name, su_email, su_mobile, su_address;

    @FXML
    private PasswordField su_password, su_cpassword;

    @FXML
    private Button SubmitSignUpBtn;


    public void SubmitSignUp() throws SQLException {

        String name = su_name.getText();
        String email = su_email.getText();
        String mobile = su_mobile.getText();
        String address = su_address.getText();
        String password = su_password.getText();
        String cpassword = su_cpassword.getText();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;

            String sql = "INSERT INTO USER_ (USER_ID, USER_NAME, USER_PASSWORD, USER_MOBILE,USER_EMAIL, USER_ADDRESS) VALUES (?, ?, ?, ?,?, ?)";

            if (!email.isEmpty() && !password.isEmpty()){
                try {
                    preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setInt(1, 2);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, mobile);
                    preparedStatement.setString(5, email);
                    preparedStatement.setString(6, address);

                    resultSet=preparedStatement.executeQuery();

                    System.out.println("Row Inserted Successfully!");
                    resultSet.close();
                }
                catch (Exception e) {
                    System.out.println("A new insertion failed! : "+e.getMessage());
                }
            }
            else{
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Please Enter All Fields!", "Error!", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

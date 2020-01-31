package Main.CODE.Products.AddNewMobile;

import Main.CODE.Products.Mobile;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AddNewMobileController {

    @FXML
    private TextField nMobileId;

    @FXML
    private TextField nMobileName;

    @FXML
    private TextField nMobileDesc;

    @FXML
    private TextField nMobileModel;

    @FXML
    private TextField nMobileType;

    @FXML
    private Button AddMobile;

    public void AddMobile() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            int id = Integer.parseInt(nMobileId.getText());
            String name = nMobileName.getText();
            String type = nMobileType.getText();
            String model = nMobileModel.getText();
            String desc = nMobileDesc.getText();

            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;

            String sql = "INSERT INTO MOBILE (MOB_ID, MOB_NAME, MOB_TYPE, MOB_MODEL, MOB_DESC) VALUES (?, ?, ?, ?,?)";

            if (name != ""){
                try {
                    preparedStatement = con.prepareStatement(sql);

                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, type);
                    preparedStatement.setString(4, model);
                    preparedStatement.setString(5, desc);

                    resultSet=preparedStatement.executeQuery();

                    final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Row Successfully Inserted!", "Success!", JOptionPane.PLAIN_MESSAGE);

                    resultSet.close();
                }
                catch (Exception e) {
                    final JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Error: "+e.getMessage(), "Error!", JOptionPane.PLAIN_MESSAGE);

                }
            }
            else{
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Please Enter All Fields!", "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Main.CODE.Products.DeleteMobile;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;

public class DeleteMobileController {

    @FXML
    Button DeletionButton;

    @FXML
    TextField ResultDeletionID;

    @FXML
    Label ResultDeletion;

    public void DeleteMobileBtn() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            int id = Integer.parseInt(ResultDeletionID.getText());

            String query = "DELETE FROM MOBILE WHERE MOB_ID = "+id;
            ResultSet rs = st.executeQuery(query);

            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Row Successfully Deleted!", "Success!", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e) {
            ResultDeletion.setText("Error: "+e.getMessage());
        }

    }

}

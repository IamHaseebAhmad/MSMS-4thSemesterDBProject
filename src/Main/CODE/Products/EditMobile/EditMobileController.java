package Main.CODE.Products.EditMobile;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.*;


public class EditMobileController {

    @FXML
    private TextField MobileId, MobileModel, MobileName, MobileType, MobileDesc;

    @FXML
    private Button UpdateChangesBtn;

    public void UpdateChanges(){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            int id = Integer.parseInt(MobileId.getText());
            String name = MobileName.getText();
            String type = MobileType.getText();
            String model = MobileModel.getText();
            String desc = MobileDesc.getText();

            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;

            if (!name.isEmpty() && !model.isEmpty() && !type.isEmpty()){
                try {

                    String sql = "UPDATE MOBILE (MOB_ID, MOB_NAME, MOB_TYPE, MOB_MODEL, MOB_DESC)";


                    System.out.println("Row Inserted successfully!");
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

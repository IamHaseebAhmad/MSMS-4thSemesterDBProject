package Main.CODE.Products;

import Main.CODE.LoginController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class ProductsController  implements Initializable {

    private ObservableList<Mobile> mobile;

    @FXML
    private AnchorPane rPane;

    @FXML
    private Button AddNewsMobileBtn;

    @FXML
    private Button EditMobileBtn;

    @FXML
    private Button DeleteMobileBtn;

    @FXML
    private TableView<Mobile> tbData;
    @FXML
    private TableColumn<Mobile, Integer> id;
    @FXML
    private TableColumn<Mobile, String> name;
    @FXML
    private TableColumn<Mobile, String> model;
    @FXML
    private TableColumn<Mobile, String> type;
    @FXML
    private TableColumn<Mobile, String> desc;

    public ProductsController() {}

    public void initialize(URL location, ResourceBundle resources) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            String query = "select * from mobile";
            ResultSet rs = st.executeQuery(query);

            String id,name,type,model,desc;
            List<Mobile> list = new ArrayList<>();

            while(rs.next()) {

                id = rs.getString("mob_id");
                 name = rs.getString("mob_name");
                 type = rs.getString("mob_type");
                 model = rs.getString("mob_model");
                 desc = rs.getString("mob_desc");

                Mobile mobileObj=new Mobile( id,name, model, type, desc);

                list.add(mobileObj);
            }
            mobile = FXCollections.observableArrayList(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        desc.setMinWidth(100);
        tbData.setItems(mobile);
    }

    public void AddNewsMobileBtn() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddNewMobile/AddNewMobile.fxml"));
        rPane.getChildren().setAll(pane);
    }

    public void EditMobileBtn() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("EditMobile/EditMobile.fxml"));
        rPane.getChildren().setAll(pane);
    }

    public void DeleteMobileBtn() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("DeleteMobile/DeleteMobile.fxml"));
        rPane.getChildren().setAll(pane);
    }
}

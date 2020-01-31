package Main.CODE.Customers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomersController implements Initializable {

    private ObservableList<CustomerModel> customer;

    @FXML
    private TableView<CustomerModel> CusData;
    @FXML
    public TableColumn<CustomerModel, String> id;
    @FXML
    public TableColumn<CustomerModel, String> name;
    @FXML
    public TableColumn<CustomerModel, String> email;
    @FXML
    public TableColumn<CustomerModel, String> mobile;
    @FXML
    public TableColumn<CustomerModel, String> address;
    @FXML
    public TableColumn<CustomerModel, String> p_desc;

    public CustomersController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            String query = "select * from customers";
            ResultSet rs = st.executeQuery(query);

            String id,name,email,mobile,address, p_desc;
            List<CustomerModel> list = new ArrayList<>();

            while(rs.next()) {

                id = rs.getString("CUS_ID");
                name = rs.getString("CUS_NAME");
                email = rs.getString("CUS_EMAIL");
                mobile = rs.getString("CUS_MOBILE");
                address = rs.getString("CUS_ADDRESS");
                p_desc = rs.getString("CUS_PURCHASE_DESC");

                //Mobile mobileObj=new Mobile( id,name, model, type, desc);
                CustomerModel cModel = new CustomerModel(id, name, email, mobile, address, p_desc);
                list.add(cModel);
            }
            customer = FXCollections.observableArrayList(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(40);

        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        email.setMinWidth(60);

        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        p_desc.setCellValueFactory(new PropertyValueFactory<>("p_desc"));
        p_desc.setMinWidth(100);


        CusData.setItems(customer);

    }
}

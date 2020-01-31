package Main.CODE.Payments;

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

public class PaymentsController implements Initializable {

    private ObservableList<PaymentsModel> OLpayments;

    @FXML
    private TableView<PaymentsModel> tbPayData;
    @FXML
    private TableColumn<PaymentsModel, Integer> id;
    @FXML
    private TableColumn<PaymentsModel, String> date;
    @FXML
    private TableColumn<PaymentsModel, Integer> cus_id;
    @FXML
    private TableColumn<PaymentsModel, Integer> amount;
    @FXML
    private TableColumn<PaymentsModel, String> desc;

    public PaymentsController() {

    }

    public void initialize(URL location, ResourceBundle resources) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            String query = "select * from payments";
            ResultSet rs = st.executeQuery(query);

            String desc,date, id,cus_id,amount;
            List<PaymentsModel> list = new ArrayList<>();

            while(rs.next()) {

                id = rs.getString("PAY_ID");
                cus_id = rs.getString("PAY_CUS_ID");
                amount = rs.getString("PAY_AMOUNT");
                date = rs.getString("PAY_DATE");
                desc = rs.getString("PAY_DESCRIPTION");

                PaymentsModel pModel = new PaymentsModel(id, cus_id, amount, date, desc);
                list.add(pModel);
            }
            OLpayments = FXCollections.observableArrayList(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cus_id.setCellValueFactory(new PropertyValueFactory<>("cus_id"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        tbPayData.setItems(OLpayments);
    }
}

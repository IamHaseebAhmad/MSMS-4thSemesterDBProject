package Main.CODE.Reports;

import Main.CODE.Reports.ReportModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

    private ObservableList<ReportModel> Lcustomer;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<ReportModel> ReportData;
    @FXML
    public TableColumn<ReportModel, String> Custoid;
    @FXML
    public TableColumn<ReportModel, String> CustoMobile;
    @FXML
    public TableColumn<ReportModel, String> MModel;
    @FXML
    public TableColumn<ReportModel, String> MType;
    @FXML
    public TableColumn<ReportModel, String> CustoName;
    @FXML
    public TableColumn<ReportModel, String> CustoEmail;

    public ReportsController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement st = con.createStatement();

            String query = "SELECT c.CUS_ID, mob_name, mob_model, mob_type, c.CUS_NAME, c.CUS_EMAIL FROM MOBILE m NATURAL JOIN CUSTOMERS c WHERE CUS_ID=MOB_ID";
            ResultSet rs =  st.executeQuery(query);

            String cid,mName,rModel,rType,rName, rEmail;

            List<ReportModel> list = new ArrayList<>();

            while(rs.next()) {
                cid = rs.getString("CUS_ID");
                mName = rs.getString("mob_name");
                rModel = rs.getString("mob_model");
                rType = rs.getString("mob_type");
                rName  = rs.getString("CUS_NAME");
                rEmail = rs.getString("CUS_EMAIL");

                //System.out.println(cid +""+mName+""+rModel+""+rType+""+rName+""+rEmail);

                ReportModel reportModel = new ReportModel(cid, mName, rModel, rType, rName, rEmail);
                list.add(reportModel);
            }
            Lcustomer = FXCollections.observableArrayList(list);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Custoid.setCellValueFactory(new PropertyValueFactory<>("Custoid"));
        CustoMobile.setCellValueFactory(new PropertyValueFactory<>("CustoMobile"));
        MModel.setCellValueFactory(new PropertyValueFactory<>("MModelm"));
        MType.setCellValueFactory(new PropertyValueFactory<>("MType"));
        CustoName.setCellValueFactory(new PropertyValueFactory<>("CustoName"));
        CustoEmail.setCellValueFactory(new PropertyValueFactory<>("CustoEmail"));

        ReportData.setItems(Lcustomer);
    }
}

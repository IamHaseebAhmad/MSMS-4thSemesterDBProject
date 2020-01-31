package Main.CODE.Reports;

public class ReportModel {

    public ReportModel(){
    }

    //private String cid,mName,rModel,rType,rName, rEmail;

    private String Custoid, CustoMobile, MModelm, MType, CustoName, CustoEmail;

    public ReportModel(String custoid, String custoMobile, String MModelm, String MType, String custoName, String custoEmail) {
        Custoid = custoid;
        CustoMobile = custoMobile;
        this.MModelm = MModelm;
        this.MType = MType;
        CustoName = custoName;
        CustoEmail = custoEmail;
    }

    public String getCustoid() {
        return Custoid;
    }

    public void setCustoid(String custoid) {
        Custoid = custoid;
    }

    public String getCustoMobile() {
        return CustoMobile;
    }

    public void setCustoMobile(String custoMobile) {
        CustoMobile = custoMobile;
    }

    public String getMModelm() {
        return MModelm;
    }

    public void setMModelm(String MModelm) {
        this.MModelm = MModelm;
    }

    public String getMType() {
        return MType;
    }

    public void setMType(String MType) {
        this.MType = MType;
    }

    public String getCustoName() {
        return CustoName;
    }

    public void setCustoName(String custoName) {
        CustoName = custoName;
    }

    public String getCustoEmail() {
        return CustoEmail;
    }

    public void setCustoEmail(String custoEmail) {
        CustoEmail = custoEmail;
    }
}

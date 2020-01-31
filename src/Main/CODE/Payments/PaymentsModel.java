package Main.CODE.Payments;

public class PaymentsModel {

    private String date,desc, id,cus_id,amount;

    public PaymentsModel(){

    }

    public PaymentsModel(String id, String cus_id, String amount, String date, String desc) {

        this.id=id;
        this.date=date;
        this.cus_id=cus_id;
        this.amount=amount;
        this.desc=desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

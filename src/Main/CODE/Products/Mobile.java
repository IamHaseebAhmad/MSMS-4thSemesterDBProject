package Main.CODE.Products;

public class Mobile {

    private String id;
    private String name;
    private String model;
    private String type;
    private String desc;

    public Mobile(){}

    public Mobile(String id, String name, String model, String type, String desc){
        this.id = id;
        this.name = name;
        this.model = model;
        this.type = type;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

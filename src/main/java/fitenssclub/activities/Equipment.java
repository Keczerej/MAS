package fitenssclub.activities;

public class Equipment {

    private String name;
    private Activity activity;

    protected Equipment(String name, Activity activity) {
        this.name = name;
        this.activity = activity;
    }

    public void removeFromEquipmentList() {
        this.activity.equipmentList.remove(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

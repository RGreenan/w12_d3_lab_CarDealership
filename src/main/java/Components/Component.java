package Components;

public abstract class Component {

    private String make;
    private String model; //TODO: Convert to Enums


    public Component(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

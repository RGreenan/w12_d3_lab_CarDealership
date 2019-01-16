package Components;

public class Seat extends Component{

    private  MaterialType material;

    public Seat(String make, String model, MaterialType material) {
        super(make, model);
        this.material = material;

    }

    public MaterialType getMaterial() {
        return material;
    }
}

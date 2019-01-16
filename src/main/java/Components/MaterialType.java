package Components;

public enum MaterialType {
    LEATHER("Leather"),
    PLEATHER("Pleather"),
    NYLON("Nylon");


    private final String stringName;

    MaterialType(String stringName) {
        this.stringName = stringName;
    }

    public String getStringName() {
        return stringName;
    }
}

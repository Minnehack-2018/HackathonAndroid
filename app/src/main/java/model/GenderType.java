package model;

public enum GenderType {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    private String type;

    GenderType(String type) {
        this.type = type;
    }

    public  String type() {
        return type;
    }
}

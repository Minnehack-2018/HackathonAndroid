package winningteam.minnehack.io.hackathonandroid;

public class UserModel {

    //Private User Variables
    private String first_name;
    private String last_name;

    private double weight;
    private double height;

    //This can be renamed, just a temporary placeholder
    private enum genderModel {
        MALE, FEMALE, OTHER;
    }

    private genderModel gender;

    public UserModel() {
        first_name = "";
        last_name = "";
        weight = 0;
        height = 0;
        gender = genderModel.MALE;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public genderModel getGender() {
        return gender;
    }

    public void setGender(genderModel gender) {
        this.gender = gender;
    }

    public UserModel(String first_name, String last_name, double weight, double height, genderModel gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }
}

package model;

import android.arch.persistence.room.Entity;

import java.util.List;

@Entity(tableName = "warm-ups")
public class WarmUp {
    private int id;
    private String name;
    private String repetitions;

    private List<WarmUpImage> images;

    public WarmUp(int id, String name, String repetitions, List<WarmUpImage> images) {
        this.id = id;
        this.name = name;
        this.repetitions = repetitions;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(String repetitions) {
        this.repetitions = repetitions;
    }

    public List<WarmUpImage> getImages() {
        return images;
    }

    public void setImages(List<WarmUpImage> images) {
        this.images = images;
    }
}

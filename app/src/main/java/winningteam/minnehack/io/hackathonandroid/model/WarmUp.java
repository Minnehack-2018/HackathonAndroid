package winningteam.minnehack.io.hackathonandroid.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

@Entity(tableName = "warmups", foreignKeys = @ForeignKey(entity = Sport.class, parentColumns = "id", childColumns = "sportId"),
indices = {@Index(value = "sportId")})
public class WarmUp {
    @PrimaryKey
    private int id;
    private String name;
    private String repetitions;
    private int sportId;

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    @TypeConverters(winningteam.minnehack.io.hackathonandroid.TypeConverters.class)
    private WarmUpImage image;

    public WarmUp(int id, String name, String repetitions, WarmUpImage image) {
        this.id = id;
        this.name = name;
        this.repetitions = repetitions;
        this.image = image;
    }

    @Ignore
    public WarmUp() {
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

    public WarmUpImage getImage() {
        return image;
    }

    public void setImage(WarmUpImage image) {
        this.image = image;
    }
}

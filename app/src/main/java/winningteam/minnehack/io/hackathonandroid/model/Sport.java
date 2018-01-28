package winningteam.minnehack.io.hackathonandroid.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sports")
public class Sport {
    @PrimaryKey
    private int id;
    private String name;

    public Sport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Ignore
    public Sport() {
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
}

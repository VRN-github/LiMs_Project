package n.vrn.limsapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sample {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public Sample(String name) {
        this.name = name;
    }
}

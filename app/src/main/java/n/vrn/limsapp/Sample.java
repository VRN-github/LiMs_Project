package n.vrn.limsapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sample {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String type;
    public String status;
    public long timestamp;

    public Sample(String name, String type, String status, long timestamp) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.timestamp = timestamp;
    }
}

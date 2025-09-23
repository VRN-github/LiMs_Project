package limsapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sample {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String sampleName;
    public String status;
}

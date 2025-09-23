package limsapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Test {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String testName;
    public String sampleId;
    public String status;
}

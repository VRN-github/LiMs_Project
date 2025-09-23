package limsapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import limsapp.models.Sample;

@Dao
public interface SampleDao {
    @Insert
    void insert(Sample sample);

    @Query("SELECT * FROM Sample")
    List<Sample> getAllSamples();
}

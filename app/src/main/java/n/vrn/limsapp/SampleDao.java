package n.vrn.limsapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface SampleDao {
    @Query("SELECT * FROM Sample")
    List<Sample> getAll();

    @Insert
    void insert(Sample sample);
}

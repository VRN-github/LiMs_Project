package n.vrn.limsapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface SampleDao {
    @Query("SELECT * FROM Sample ORDER BY timestamp DESC")
    List<Sample> getAll();

    @Query("SELECT * FROM Sample WHERE status = :status")
    List<Sample> getByStatus(String status);

    @Insert
    void insert(Sample sample);

    @Update
    void update(Sample sample);

    @Delete
    void delete(Sample sample);
}

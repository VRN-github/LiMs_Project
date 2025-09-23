package limsapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import limsapp.models.Test;

@Dao
public interface TestDao {
    @Insert
    void insert(Test test);

    @Query("SELECT * FROM Test")
    List<Test> getAllTests();
}

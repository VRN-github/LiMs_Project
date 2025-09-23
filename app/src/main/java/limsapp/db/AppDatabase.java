package limsapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import limsapp.models.Sample;
import limsapp.models.Test;
import limsapp.models.User;

@Database(entities = {Sample.class, Test.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SampleDao sampleDao();
    public abstract TestDao testDao();
    public abstract UserDao userDao();
}

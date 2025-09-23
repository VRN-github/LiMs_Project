package n.vrn.limsapp;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sample.class}, version = 1)
public abstract class SampleDatabase extends RoomDatabase {
    public abstract SampleDao sampleDao();

    private static SampleDatabase INSTANCE;

    public static SampleDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    SampleDatabase.class, "lims-db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}

package n.vrn.limsapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SampleAdapter adapter;
    private SampleDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = SampleDatabase.getInstance(this);
        RecyclerView recyclerView = findViewById(R.id.sampleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new SampleAdapter();
        recyclerView.setAdapter(adapter);
        loadSamples();

        FloatingActionButton addButton = findViewById(R.id.addSampleButton);
        addButton.setOnClickListener(v -> showAddSampleDialog());
    }

    private void loadSamples() {
        List<Sample> samples = db.sampleDao().getAll();
        adapter.setSamples(samples);
    }

    private void showAddSampleDialog() {
        EditText input = new EditText(this);
        new AlertDialog.Builder(this)
            .setTitle("Add Sample")
            .setMessage("Enter sample name:")
            .setView(input)
            .setPositiveButton("Add", (dialog, which) -> {
                String name = input.getText().toString().trim();
                if (!name.isEmpty()) {
                    db.sampleDao().insert(new Sample(name));
                    loadSamples();
                } else {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }
}

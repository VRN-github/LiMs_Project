package n.vrn.limsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SampleDatabase db;
    private SampleAdapter adapter;
    private RecyclerView recyclerView;
    private List<Sample> sampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = SampleDatabase.getInstance(this);
        recyclerView = findViewById(R.id.sampleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sampleList = db.sampleDao().getAll();
        adapter = new SampleAdapter(sampleList);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.addSampleFab).setOnClickListener(v -> showAddSampleDialog());
    }

    private void showAddSampleDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_sample, null);
        EditText nameInput = dialogView.findViewById(R.id.sampleNameInput);
        EditText typeInput = dialogView.findViewById(R.id.sampleTypeInput);
        Spinner statusSpinner = dialogView.findViewById(R.id.statusSpinner);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.sample_status_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(spinnerAdapter);

        new AlertDialog.Builder(this)
                .setTitle("Add Sample")
                .setView(dialogView)
                .setPositiveButton("Save", (dialog, which) -> {
                    String name = nameInput.getText().toString().trim();
                    String type = typeInput.getText().toString().trim();
                    String status = statusSpinner.getSelectedItem().toString();

                    if (name.isEmpty() || type.isEmpty()) {
                        Toast.makeText(this, "Name and type required", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Sample sample = new Sample(name, type, status, System.currentTimeMillis());
                    db.sampleDao().insert(sample);
                    adapter.updateList(db.sampleDao().getAll());
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}

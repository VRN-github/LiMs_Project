package n.vrn.limsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder> {
    private List<Sample> sampleList;

    public SampleAdapter(List<Sample> sampleList) {
        this.sampleList = sampleList;
    }

    public void updateList(List<Sample> newList) {
        sampleList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position) {
        Sample sample = sampleList.get(position);
        holder.name.setText(sample.name);
        holder.type.setText("Type: " + sample.type);
        holder.status.setText("Status: " + sample.status);
        holder.timestamp.setText(new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(sample.timestamp));
    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }

    static class SampleViewHolder extends RecyclerView.ViewHolder {
        TextView name, type, status, timestamp;

        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sampleName);
            type = itemView.findViewById(R.id.sampleType);
            status = itemView.findViewById(R.id.sampleStatus);
            timestamp = itemView.findViewById(R.id.sampleTimestamp);
        }
    }
}

package n.vrn.limsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder> {
    private List<Sample> samples = new ArrayList<>();

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
        notifyDataSetChanged();
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample, parent, false);
        return new SampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        holder.textView.setText(samples.get(position).name);
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    static class SampleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        SampleViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sampleName);
        }
    }
}


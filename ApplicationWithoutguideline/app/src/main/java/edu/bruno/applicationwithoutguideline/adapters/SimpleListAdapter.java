package edu.bruno.applicationwithoutguideline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.bruno.applicationwithoutguideline.R;

/**
 * Created by bruno.oliveira on 6/17/16.
 */
public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;

    public SimpleListAdapter(Context context) {
        if (context != null)
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.cell_simple_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String text = "Item linha " + ++position;
        holder.mTextView.setText(text);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_simple_text_title)
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

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
import edu.bruno.applicationwithoutguideline.interfaces.OnItemClickListener;

/**
 * Created by bruno.oliveira on 6/17/16.
 */
public class ThreeColumnListAdapter extends RecyclerView.Adapter<ThreeColumnListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mListener;

    public ThreeColumnListAdapter(Context context, OnItemClickListener listener) {
        mListener = listener;
        if (context != null)
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.cell_three_columns, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final int pos = position;
        holder.mTextViewColumn1.setText("C1 - " + ++position);
        holder.mTextViewColumn2.setText("C2 - " + ++position);
        holder.mTextViewColumn3.setText("C3 - " + ++position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onItemClick(v, pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_three_colunm_1)
        TextView mTextViewColumn1;
        @BindView(R.id.cell_three_colunm_2)
        TextView mTextViewColumn2;
        @BindView(R.id.cell_three_colunm_3)
        TextView mTextViewColumn3;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

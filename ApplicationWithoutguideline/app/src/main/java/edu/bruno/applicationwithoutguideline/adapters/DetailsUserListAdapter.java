package edu.bruno.applicationwithoutguideline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.bruno.applicationwithoutguideline.R;
import edu.bruno.applicationwithoutguideline.interfaces.OnCheckedChangeStateListener;
import edu.bruno.applicationwithoutguideline.interfaces.OnItemClickListener;

/**
 * Created by bruno.oliveira on 6/17/16.
 */
public class DetailsUserListAdapter extends RecyclerView.Adapter<DetailsUserListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mItemClickListener;
    private OnCheckedChangeStateListener mCheckedChangeListener;

    public DetailsUserListAdapter(Context context, OnItemClickListener itemClickListener, OnCheckedChangeStateListener checkedChangeListener) {
        mItemClickListener = itemClickListener;
        mCheckedChangeListener = checkedChangeListener;
        if (context != null)
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.cell_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final int pos = position;
        holder.mTextViewDetailsLine1.setText("Linha 1 - " + ++position);
        holder.mTextViewDetailsLine2.setText("Linha 2 - " + ++position);
        holder.mTextViewDetailsLine3.setText("Linha 3 - " + ++position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null)
                    mItemClickListener.onItemClick(v, pos);
            }
        });

        holder.mCheckBoxDetails.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCheckedChangeListener != null)
                    mCheckedChangeListener.onCheckedChanged(holder.itemView, pos, isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_details_line1)
        TextView mTextViewDetailsLine1;
        @BindView(R.id.cell_details_line2)
        TextView mTextViewDetailsLine2;
        @BindView(R.id.cell_details_line3)
        TextView mTextViewDetailsLine3;
        @BindView(R.id.cell_details_warning)
        TextView mTextViewDetailsWarning;
        @BindView(R.id.cell_details_icon)
        ImageView mImageViewDetailsIcon;
        @BindView(R.id.cell_details_checkbox)
        CheckBox mCheckBoxDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

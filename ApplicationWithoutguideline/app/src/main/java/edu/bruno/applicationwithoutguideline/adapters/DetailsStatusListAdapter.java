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
 * Created by bruno.oliveira on 6/20/16.
 */
public class DetailsStatusListAdapter extends RecyclerView.Adapter<DetailsStatusListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mListener;
    private OnCheckedChangeStateListener mCheckedChangeListener;

    public DetailsStatusListAdapter(Context context, OnItemClickListener listener, OnCheckedChangeStateListener checkedChangeListener) {
        mListener = listener;
        mCheckedChangeListener = checkedChangeListener;
        if (context != null)
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.cell_details_status, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final int pos = position;
        holder.mTextViewDetailsStatusLine1.setText("Linha 1");
        holder.mTextViewDetailsStatusLine2Column1.setText("Linha 2 coluna 1");
        holder.mTextViewDetailsStatusLine2Column2.setText(" - Linha 2 coluna 2");

        holder.mTextViewDetailsStatusColumn1.setText("Coluna 1");
        holder.mImageViewDetailsStatusColumn1.setImageResource(R.mipmap.ic_warning_yellow_36dp);
        holder.mTextViewDetailsStatusColumn2.setText("Coluna 2");
        holder.mImageViewDetailsStatusColumn2.setImageResource(R.mipmap.ic_warning_yellow_36dp);
        holder.mTextViewDetailsStatusColumn3.setText("Coluna 3");
        holder.mImageViewDetailsStatusColumn3.setImageResource(R.mipmap.ic_delete_36dp);
        holder.mTextViewDetailsStatusColumn4.setText("Coluna 4");
        holder.mImageViewDetailsStatusColumn4.setImageResource(R.mipmap.ic_check_36dp);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v, pos);
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

        @BindView(R.id.cell_details_status_line1) TextView mTextViewDetailsStatusLine1;
        @BindView(R.id.cell_details_status_line2_column1) TextView mTextViewDetailsStatusLine2Column1;
        @BindView(R.id.cell_details_status_line2_column2) TextView mTextViewDetailsStatusLine2Column2;
        @BindView(R.id.cell_details_status_textview_column1) TextView mTextViewDetailsStatusColumn1;
        @BindView(R.id.cell_details_status_imageview_column1) ImageView mImageViewDetailsStatusColumn1;
        @BindView(R.id.cell_details_status_textview_column2) TextView mTextViewDetailsStatusColumn2;
        @BindView(R.id.cell_details_status_imageview_column2) ImageView mImageViewDetailsStatusColumn2;
        @BindView(R.id.cell_details_status_textview_column3) TextView mTextViewDetailsStatusColumn3;
        @BindView(R.id.cell_details_status_imageview_column3) ImageView mImageViewDetailsStatusColumn3;
        @BindView(R.id.cell_details_status_textview_column4) TextView mTextViewDetailsStatusColumn4;
        @BindView(R.id.cell_details_status_imageview_column4) ImageView mImageViewDetailsStatusColumn4;

        @BindView(R.id.cell_details_status_image)
        ImageView mImageViewDetailsIcon;
        @BindView(R.id.cell_details_status_checkbox)
        CheckBox mCheckBoxDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

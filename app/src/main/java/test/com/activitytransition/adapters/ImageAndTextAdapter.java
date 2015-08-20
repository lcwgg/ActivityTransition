package test.com.activitytransition.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitytransition.R;

/**
 * Created by laetitia on 4/30/15.
 */
public class ImageAndTextAdapter extends RecyclerView.Adapter<ImageAndTextAdapter.ViewHolder> {

    private OnItemCLickListener mItemClickListener;
    private List<Integer> mImages;

    public ImageAndTextAdapter(List<Integer> images) {
        mImages = images;
    }

    public int getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_element_image_and_text, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mImageView.setImageResource(getItem(i));
        viewHolder.mTextView.setText(String.format("Dog # %1$d", i));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @InjectView(R.id.imageview)
        ImageView mImageView;
        @InjectView(R.id.textview)
        TextView mTextView;

        public ViewHolder(final View view) {
            super(view);
            ButterKnife.inject(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {

                mItemClickListener.onItemClick(
                        mImageView,
                        mTextView,
                        getItem(getLayoutPosition())
                );
            }
        }
    }

    public interface OnItemCLickListener {
        void onItemClick(View imageView, View textView, int imageRefId);
    }

    public void setOnItemClickListener(final OnItemCLickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

}

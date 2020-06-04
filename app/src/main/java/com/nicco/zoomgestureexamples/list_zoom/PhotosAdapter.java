package com.nicco.zoomgestureexamples.list_zoom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.nicco.zoomgestureexamples.R;

import java.util.List;
import java.util.Random;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    private final Context context;
    private List<String> mPhotoUris;
 
    public PhotosAdapter(Context context, List<String> photoUris) {
        this.context = context;
        this.mPhotoUris = photoUris;
    }
 
    @Override
    public PhotosAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_photo_grid, parent, false));
    }
 
    @Override
    public void onBindViewHolder(PhotosAdapter.PhotoViewHolder holder, int position) {
            Integer random = new Random().nextInt(2);

            holder.textView.setText(mPhotoUris.get(position));

            if(random == 0) {
                holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            } else if (random == 1) {
                holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            } else if (random == 2) {
                holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
            }
    }
 
    @Override
    public int getItemCount() {
        return mPhotoUris.size();
    }
 
    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
 
        public PhotoViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
package com.nicco.zoomgestureexamples.list_textview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.nicco.zoomgestureexamples.R;

@SuppressWarnings("WeakerAccess")
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ItemHolder> {

    private int mCount;
    private static OnClick onClickListener;

    public SimpleAdapter(int count, OnClick click) {
        mCount = count;
        onClickListener = click;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup container, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View root = inflater.inflate(R.layout.item_view, container, false);

        return new ItemHolder(root);
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int position) {
        itemHolder.mId.setText(Integer.toString(position));
    }

    @Override
    public int getItemCount() {
        return mCount;
    }


    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mId;

        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mId = (TextView) itemView.findViewById(R.id.id);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), mId.getText(), Toast.LENGTH_SHORT).show();
            onClickListener.onClick();
        }
    }
}

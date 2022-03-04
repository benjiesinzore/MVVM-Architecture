package com.example.mvvmarchitecture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context, List<NicePlace> nicePlaces) {
        mNicePlaces = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layoutlist_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mName.setText(mNicePlaces.get(position).getTitle());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlaces.get(position).getImageUrl())
                .into(holder.mImage);


    }



    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mImage;
        private TextView mName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
        }
    }

}
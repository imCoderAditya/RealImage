package com.realimage.screens;

import static com.realimage.R.drawable.ic_home_24;
import static com.realimage.R.drawable.splace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.realimage.R;
import com.realimage.model.PexelsModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PexelsAdapter extends RecyclerView.Adapter<PexelsViewHolder> {
    private Context context;
    private List<PexelsModel> pexelsModelList;

    public PexelsAdapter(Context context, List<PexelsModel> pexelsModelList) {
        this.context = context;
        this.pexelsModelList = pexelsModelList;
    }

    @NonNull
    @Override
    public PexelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mylist, parent, false);
        return new PexelsViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull PexelsViewHolder holder, int position) {


        try {
            holder.photographer_textView.setText(pexelsModelList.get(position).getPhotographer());
            holder.cView.setCardBackgroundColor(Color.parseColor(pexelsModelList.get(position).getAvgColor()));
            Glide.with(context).
                    load(pexelsModelList.get(position).getLarge2x())
                    .placeholder(holder.progressBar.getProgress())
                    .addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            holder.progressBar.setVisibility(View.VISIBLE);
                            return false;

                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            holder.progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(holder.imageView);
            Glide.with(context)
                    .load(pexelsModelList.get(position).getLarge2x())
                    .placeholder(R.color.grey_blue)
                    .into(holder.circleImageView);
            holder.circleImageView.setBorderColor(Color.parseColor(pexelsModelList.get(position).getAvgColor()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return pexelsModelList.size();
    }
}

class PexelsViewHolder extends RecyclerView.ViewHolder {
    TextView photographer_textView;
    ImageView imageView;
    ProgressBar progressBar;
    CardView cView;
    CircleImageView circleImageView;

    public PexelsViewHolder(@NonNull View itemView) {
        super(itemView);

        photographer_textView = (TextView) itemView.findViewById(R.id.text_1);
        imageView = (ImageView) itemView.findViewById(R.id.imageViewItem);
        progressBar = (ProgressBar) itemView.findViewById(R.id.img_progressBar);
        cView = (CardView) itemView.findViewById(R.id.cardView);
        circleImageView =(CircleImageView) itemView.findViewById(R.id.profile_image);
    }
}
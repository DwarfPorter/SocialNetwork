package ru.geekbrains.socialnetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    private final SocSource dataSource;
    private OnItemClickListener itemClickListener;

    public SocialNetworkAdapter(SocSource dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Soc soc = dataSource.getSoc(position);
        holder.setData(soc.getDescription(), soc.getPicture(), soc.isLike());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView description;
        private ImageView image;
        private CheckBox like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);
            like = itemView.findViewById(R.id.like);
        }

        public void setData(String description, int picture, boolean like){
            getDescription().setText(description);
            getImage().setImageResource(picture);
            getLike().setChecked(like);
        }

        public TextView getDescription() {
            return description;
        }

        public ImageView getImage() {
            return image;
        }

        public CheckBox getLike() {
            return like;
        }
    }
}

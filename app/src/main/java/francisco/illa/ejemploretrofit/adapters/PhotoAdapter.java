package francisco.illa.ejemploretrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import francisco.illa.ejemploretrofit.R;
import francisco.illa.ejemploretrofit.modelos.Photo;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoVH> {

    private Context context;
    private List<Photo> objects;
    private int resources;

    public PhotoAdapter(Context context, List<Photo> objects, int resources) {
        this.context = context;
        this.objects = objects;
        this.resources = resources;
    }


    @NonNull
    @Override
    public PhotoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoVH(LayoutInflater.from(context).inflate(resources, null));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoVH holder, int position) {
        Photo p = objects.get(position);

        holder.lbTitulo.setText(p.getTitle());
        Picasso.get().load(p.getUrl()).placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_background).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
       return objects.size();
    }

    public class PhotoVH extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView lbTitulo;
        public PhotoVH(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.imagePhotoCard);
            lbTitulo = itemView.findViewById(R.id.lbTituloPhotoCard);

        }
    }
}

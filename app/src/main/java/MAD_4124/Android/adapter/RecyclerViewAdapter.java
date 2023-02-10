package MAD_4124.Android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import MAD_4124.Android.R;
import MAD_4124.Android.model.FavPlaces;

public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter<T>.ViewHolder> {
    private static final String TAG = "Cannot invoke method length() on null object";

    private List<T> tList;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public RecyclerViewAdapter(List<T> tList, Context context, OnItemClickListener onItemClickListener) {
        this.tList = tList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        T t = tList.get(position);
        FavPlaces e = (FavPlaces) t;
        Log.d(TAG, "onBindViewHolder: none");
    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView postal_code;
        private TextView country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_row);
            postal_code = itemView.findViewById(R.id.postal_row);
            country = itemView.findViewById(R.id.country);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}

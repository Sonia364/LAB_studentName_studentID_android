package MAD_4124.Android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import MAD_4124.Android.adapter.RecyclerViewAdapter;
import MAD_4124.Android.databinding.ActivityMainBinding;
import MAD_4124.Android.model.FavPlaces;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {
    ActivityMainBinding binding = null;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<FavPlaces> placesList;
    private FavPlaces deletedPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(binding == null){
            binding = ActivityMainBinding.inflate(getLayoutInflater());
        }

        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        placesList = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPlaceActivity.class);
            startActivity(intent);

        });

    }

    @Override
    public void onItemClick(int position) {

    }
}
package MAD_4124.Android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import MAD_4124.Android.adapter.RecyclerViewAdapter;
import MAD_4124.Android.databinding.ActivityMainBinding;
import MAD_4124.Android.model.FavPlaces;
import MAD_4124.Android.model.FavPlaceViewModel;

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
        FavPlaces fav = new FavPlaces("Fairview", "CF6784", "Canada");
        FavPlaceViewModel.getList().add(fav);
        placesList = FavPlaceViewModel.getList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {


//            Intent intent = new Intent(MainActivity.this, AddPlaceActivity.class);
//            startActivity(intent);

        });

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewAdapter = new RecyclerViewAdapter(placesList, this, this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void updateUI() {
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Employees Menu Selected", Toast.LENGTH_SHORT).show();
    }


}
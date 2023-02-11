package MAD_4124.Android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import MAD_4124.Android.adapter.RecyclerViewAdapter;
import MAD_4124.Android.databinding.ActivityMainBinding;
import MAD_4124.Android.helper.SwipeHelper;
import MAD_4124.Android.helper.SwipeUnderlayButtonClickListener;
import MAD_4124.Android.model.FavPlaces;
import MAD_4124.Android.model.FavPlaceViewModel;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {
    ActivityMainBinding binding = null;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private SwipeHelper swipeHelper;
    private List<FavPlaces> placesList;
    private FavPlaces deletedPlace;

    private FavPlaceViewModel favPlaceViewModel;
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
        favPlaceViewModel.getList().add(fav);
        placesList = favPlaceViewModel.getList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPlaceActivity.class);
            startActivity(intent);

        });

        swipeHelper = new SwipeHelper(this, 300, recyclerView) {
            @Override
            protected void instantiateSwipeButton(RecyclerView.ViewHolder viewHolder, List<SwipeUnderlayButton> buffer) {
                buffer.add(new SwipeUnderlayButton(MainActivity.this,
                        "Delete",
                        R.drawable.ic_delete_white,
                        30,
                        50,
                        Color.parseColor("#ff3c30"),
                        SwipeDirection.LEFT,
                        position -> {
                            deletePlace(position);
                        }));
            }
        };

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

    private void deletePlace(int position) {
        FavPlaces favPlace = placesList.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Are you sure?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            deletedPlace = favPlace;
            FavPlaceViewModel.deleteList(position);
            recyclerViewAdapter.notifyItemRemoved(position);
            Snackbar.make(recyclerView, deletedPlace.getName() + " is deleted!", Snackbar.LENGTH_LONG)
                    .setAction("Undo", v -> FavPlaceViewModel.setList(deletedPlace)).show();
            Toast.makeText(MainActivity.this, deletedPlace.getName() + " deleted", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No", (dialog, which) -> recyclerViewAdapter.notifyItemChanged(position));
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




}
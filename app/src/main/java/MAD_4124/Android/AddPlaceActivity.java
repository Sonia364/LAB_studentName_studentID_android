package MAD_4124.Android;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import MAD_4124.Android.databinding.ActivityMainBinding;
import MAD_4124.Android.databinding.AddPlaceActivityBinding;

public class AddPlaceActivity extends AppCompatActivity {

    AddPlaceActivityBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(binding == null){
            binding = AddPlaceActivityBinding.inflate(getLayoutInflater());
        }

        setContentView(binding.getRoot());
    }
}

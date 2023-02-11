package MAD_4124.Android.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavPlaceViewModel extends ViewModel {

    static private List<FavPlaces> allPlacesList = new ArrayList<>();
    static public List<FavPlaces> getList() {

        return allPlacesList;
    }

    static public void setList(FavPlaces list) {
        allPlacesList.add(list);
    }

    static public void deleteList(int position) {
        allPlacesList.remove(position);
    }
}

package MAD_4124.Android.model;

public class FavPlaces {
    String name;
    String postal_code;
    String country;

    public FavPlaces(String name, String postal_code, String country) {
        this.name = name;
        this.postal_code = postal_code;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

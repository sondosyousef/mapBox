package com.example.mapbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;

import java.util.ArrayList;

/**
 * Display {@link SymbolLayer} icons on the map.
 */
public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback {

    private MapView mapView;
    ArrayList<LatLng> arrayList = new ArrayList<>();
    LatLng Sebastia =new LatLng(32.27647333353645, 35.197966041977494);
    LatLng  MaqamJoseph  =new LatLng(32.213,35.284);
    LatLng  BirYacoub   =new LatLng(32.209,35.285);
    LatLng  MountGerizim  =new LatLng(32.199,35.274);
    LatLng oldCity  =new LatLng(32.219627887985354, 35.26149790571429);
    LatLng KhanTraders =new LatLng(32.21994242430669, 35.26351422125106);
    LatLng HadiPalace =new LatLng(32.22423573313789, 35.26209870877827);
    LatLng LighthouseClock =new LatLng(32.219,35.262);
    LatLng NasrMosque =new LatLng(32.21891310852186, 35.26169907305228);
    LatLng SabanaTouqan =new LatLng(32.21910978147422, 35.261180428486036);
    LatLng Turkishbaths =new LatLng(32.22485493566722, 35.23628566214025);

    ArrayList<String> title = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// Mapbox access token is configured here. This needs to be called either in your application
// object or in the same activity which contains the mapview.
       Mapbox.getInstance(this, getString(R.string.access_token));

// This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        arrayList.add(Sebastia);
        arrayList.add(MaqamJoseph);
        arrayList.add(BirYacoub);
        arrayList.add(MountGerizim);
        arrayList.add(oldCity);
        arrayList.add(KhanTraders);
        arrayList.add(HadiPalace);
        arrayList.add(LighthouseClock);
        arrayList.add(NasrMosque);
        arrayList.add(SabanaTouqan);
        arrayList.add(Turkishbaths);


        title.add("Sebastia");
        title.add("Bi'er Yacoub ");
        title.add("Maqam Joseph");
        title.add("Mount Gerizim");
        title.add("old City");
        title.add("Khan Traders");
        title.add("Abdul Hadi Palace");
        title.add("Lighthouse Clock");
        title.add("Nasr Mosque");
        title.add("Sabana Touqan");
        title.add("Turkish baths");
        mapView.getMapAsync(this);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull final MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Nablus");
                options.position(new LatLng(32.2211, 35.2544));
                mapboxMap.addMarker(options);
                for (int i = 0; i < arrayList.size(); i++) {

                    for (int j = 0; j < title.size(); j++) {

                        mapboxMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(i))));

                    }
                    mapboxMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));

                }
                mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        String markerTitle = marker.getTitle();
                        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                        intent.putExtra("title",markerTitle);
                        startActivity(intent);
                        return false;
                    }

                });

            }
        });



    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/sondosawashra/ckjqb69dd184j19rn8l08tim1"));

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}

package com.example.administrator.parkhere;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    boolean firstSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {


        mMap = googleMap;

        //following lines of codes create a custom spinner (dropdown menu bar) for selecting user type

        Spinner spinner = (Spinner) findViewById(R.id.spinnerMapTypes);
        final ArrayList<String> mapTypes = new ArrayList<>();
        mapTypes.add("Visitor");
        mapTypes.add("Student");
        mapTypes.add("Faculty");

        final MapTypesAdapter mapTypesAdapter = new MapTypesAdapter(this, mapTypes);

        spinner.setAdapter(mapTypesAdapter);

        AdapterView.OnItemSelectedListener oicl = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String mapType = mapTypes.get(position);

                if(mapType.equals("Visitor")){
                    googleMap.clear();
                    VisitorMapMarkers();
                } else if (mapType.equals("Student")){
                    googleMap.clear();
                    StudentMapMarkers();

                } else if (mapType.equals("Faculty")){
                    googleMap.clear();
                    FacultyMapMarkers();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        spinner.setOnItemSelectedListener(oicl);

        // Add a marker in Temple University and move the camera
        LatLng templeUniversity = new LatLng(39.981349, -75.155318);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(templeUniversity, 14));


        //following lines of code make a current location button
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //put marker's name into clicked string
                String markerName = marker.getTitle();

                Intent newActivityIntent = new Intent(MapsActivity.this, MapInfo.class);

                newActivityIntent.putExtra("message", markerName);

                startActivity(newActivityIntent);
            }
        });

    }

    //Following codes add a search bar onto an app and move the screen to the corresponding place

    public void onMapSearch(View view) {



        EditText locationSearch = (EditText) findViewById(R.id.searchBar);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void VisitorMapMarkers(){
        // Add markers for parking lots/garages located in Temple University
        LatLng fifteenthStreetLot = new LatLng(39.981538, -75.158967);

        //LatLng cecilBMooreLot = new LatLng(39.978714, -75.154765);

        LatLng diamondStreetLot = new LatLng(39.984827, -75.156514);

        LatLng liacourasGarage = new LatLng(39.979361, -75.159744);

        LatLng montgomeryGarage = new LatLng(39.981045, -75.151702);

        //LatLng tuttlemanLot = new LatLng(39.979805, -75.153788);

        Marker fifteenthStreetLotMarker = mMap.addMarker(new MarkerOptions().position(fifteenthStreetLot).title("")
                .title("15th Street Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_15th_street_lot)));

        /*
        Marker cecilBMooreLotMarker = mMap.addMarker(new MarkerOptions().position(cecilBMooreLot)
                .title("Cecil B. Moore Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_4perhour)));
         */

        Marker diamondStreetLotMarker
                = mMap.addMarker(new MarkerOptions().position(diamondStreetLot)
                .title("Diamond Street Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_15th_street_lot)));

        Marker liacourasGarageMarker
                = mMap.addMarker(new MarkerOptions().position(liacourasGarage)
                .title("Liacouras Garage")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_15th_street_lot)));

        Marker montgomeryGarageMarker
                = mMap.addMarker(new MarkerOptions().position(montgomeryGarage)
                .title("Montgomery Garage")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_4perhour)));

        /*
        Marker tuttlemanLotMarker
                = mMap.addMarker(new MarkerOptions().position(tuttlemanLot)
                .title("Tuttleman Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_6perhour)));
                */

    }

    public void StudentMapMarkers(){

        // Add markers for parking lots/garages located in Temple University

        LatLng tylerLot = new LatLng(39.984810, -75.156278);

        LatLng liacourasGarage = new LatLng(39.979361, -75.159744);

        LatLng montgomeryGarage = new LatLng(39.981045, -75.151702);

        LatLng diamondStreetLot = new LatLng(39.984827, -75.156514);

        LatLng templeTowersLot = new LatLng(39.977759, -75.155682);



        Marker tylerLotMarker
                = mMap.addMarker(new MarkerOptions().position(tylerLot)
                .title("Tyler Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_400semester)));

        Marker liacourasGarageMarker
                = mMap.addMarker(new MarkerOptions().position(liacourasGarage)
                .title("Liacouras Garage")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_8entry)));

        Marker montgomeryGarageMarker
                = mMap.addMarker(new MarkerOptions().position(montgomeryGarage)
                .title("Montgomery Garage")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_8entry)));

        Marker diamondStreetLotMarker
                = mMap.addMarker(new MarkerOptions().position(diamondStreetLot)
                .title("Diamond Street Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_240sem)));

        Marker templeTowersLotMarker
                = mMap.addMarker(new MarkerOptions().position(templeTowersLot)
                .title("Temple Towers Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_240sem)));
    }

    public void FacultyMapMarkers(){
        // Add markers for parking lots/garages located in Temple University

        LatLng liacourasGarage = new LatLng(39.979361, -75.159744);

        LatLng montgomeryGarage = new LatLng(39.981045, -75.151702);

        LatLng fifteenthStreetLot = new LatLng(39.981349, -75.158817);

        LatLng tylerLot = new LatLng(39.984810, -75.156278);

        LatLng diamondStreetLot = new LatLng(39.984827, -75.156514);

        LatLng templeTowersLot = new LatLng(39.977759, -75.155682);

        Marker liacourasGarageMarker
                = mMap.addMarker(new MarkerOptions().position(liacourasGarage)
                .title("Liacouras Garage")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_8entry)));

        Marker montgomeryGarageMarker
                = mMap.addMarker(new MarkerOptions().position(montgomeryGarage)
                .title("Montgomery Garage")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_8entry)));

        Marker fifteenthStreetLotMarker =
                mMap.addMarker(new MarkerOptions().position(fifteenthStreetLot)
                .title("15th Street Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_120mon)));

        Marker tylerLotMarker
                = mMap.addMarker(new MarkerOptions().position(tylerLot)
                .title("Tyler Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_120mon)));

        Marker diamondStreetLotMarker
                = mMap.addMarker(new MarkerOptions().position(diamondStreetLot)
                .title("Diamond Street Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_120mon)));

        Marker templeTowersLotMarker
                = mMap.addMarker(new MarkerOptions().position(templeTowersLot)
                .title("Temple Towers Lot")
                .snippet("Reserve")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_120mon)));

    }
}
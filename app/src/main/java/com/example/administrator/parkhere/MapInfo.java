package com.example.administrator.parkhere;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


//This class is a page user moves to when user clicks a marker on a homepage (home activity)
//this class contains a fragment (modular portion of an activity)
//If a user clicks a info radio button, this activity shows that parking lot's info
//If a user clicks a picture radio button, this activity shows that parking lot's picture.
public class MapInfo extends AppCompatActivity {

    ParkingLotInfoFragment parkingLotInfoFragment;
    ParkingLotPictureFragment parkingLotPictureFragment;

    RadioGroup rg;
    RadioButton rb;

    public static String markerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_info);

        rg = (RadioGroup) findViewById(R.id.rgroup);

        rg.check(R.id.rbInfo);

        Intent myIntent = getIntent();

        Bundle bundle = getIntent().getExtras();

        markerName = bundle.getString("message");

        parkingLotInfoFragment = new ParkingLotInfoFragment();

        addFragment(R.id.fragContainingInfoOrPicture, parkingLotInfoFragment);
        parkingLotInfoFragment.setMarkerName(markerName);
    }

    public void rbClick(View v) {

        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radiobuttonid);

        parkingLotInfoFragment = new ParkingLotInfoFragment();
        parkingLotPictureFragment = new ParkingLotPictureFragment();


        //If user clicks a "Info" radio button, this activity creates a info fragment
        //If user clicks a "Picture" radio button, this activity creates a picture fragment
        if(rb.getText().equals("Info")){
            parkingLotInfoFragment.setMarkerName(markerName);
            addFragment(R.id.fragContainingInfoOrPicture, parkingLotInfoFragment);
        } else if(rb.getText().equals("Picture")){
            parkingLotPictureFragment.setMarkerName(markerName);
            addFragment(R.id.fragContainingInfoOrPicture, parkingLotPictureFragment);
        }

    }


    //following method adds a fragment to the activity
    private void addFragment (int containerID, Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .commit();

    }

}

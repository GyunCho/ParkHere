package com.example.administrator.parkhere;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class ParkingLotInfoFragment extends Fragment {


    public static String markerName = null;

    public void setMarkerName(String string){
        markerName = string;
    }

    public ParkingLotInfoFragment() {
        // Required empty public constructor
    }

    private String parkingLotName;
    private String parkingLotAddress;
    private String parkingLotRates;
    private String parkingLotHours;

    private View layout;

    private static RatingBar ratingBar1;
    private static TextView textViewRating;
    private static Button ratingButton;

    private static Button writeReviewButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_parking_lot_info, container, false);


            ParkingLotInfo parkingLotInfo = new ParkingLotInfo(markerName);

            TextView tx1 = (TextView) layout.findViewById(R.id.textView1);
            TextView tx2 = (TextView) layout.findViewById(R.id.textView2);
            TextView tx3 = (TextView) layout.findViewById(R.id.textView3);
            TextView tx4 = (TextView) layout.findViewById(R.id.textView4);

            parkingLotInfo.setMarkerName(markerName);
            parkingLotName = parkingLotInfo.getParkingLotName();
            tx1.setText(parkingLotName);

            parkingLotInfo.setParkingLotAddress(markerName);
            parkingLotAddress = parkingLotInfo.getParkingLotAddress();
            tx2.setText(parkingLotAddress);

            parkingLotInfo.setParkingLotRates(markerName);
            parkingLotRates = parkingLotInfo.getParkingLotRates();
            tx3.setText(parkingLotRates);

            parkingLotInfo.setParkingLotHours(markerName);
            parkingLotHours = parkingLotInfo.getParkingLotHours();
            tx4.setText(parkingLotHours);

        ratingBarListener();
        ratingButtonClickListener();
        writeReviewButtonClickListener();

        return layout;
    }

    public void ratingBarListener() {
        textViewRating = (TextView) layout.findViewById(R.id.textViewRating);
        ratingBar1 = (RatingBar) layout.findViewById(R.id.ratingBar1);

        ratingBar1.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener(){
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textViewRating.setText(String.valueOf(rating));
                    }
                }
        );
    }

    public void ratingButtonClickListener(){
        ratingBar1 = (RatingBar)layout.findViewById(R.id.ratingBar1);
        ratingButton = (Button)layout.findViewById(R.id.ratingButton);


        ratingButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(),
                                String.valueOf(ratingBar1.getRating()),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }



    public void writeReviewButtonClickListener(){

        writeReviewButton = (Button)layout.findViewById(R.id.writeReviewButton);


        writeReviewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent newActivityIntent = new Intent(getActivity(), WriteReviewActivity.class);
                        newActivityIntent.putExtra("message", markerName);
                        startActivity(newActivityIntent);
                    }
                }
        );
    }

    }


/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    */


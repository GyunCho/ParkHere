package com.example.administrator.parkhere;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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

        return layout;
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
}

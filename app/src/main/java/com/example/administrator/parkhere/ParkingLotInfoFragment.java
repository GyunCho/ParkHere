package com.example.administrator.parkhere;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.InetAddress;


public class ParkingLotInfoFragment extends Fragment {


    public static String markerName = null;

    public void setMarkerName(String string){
        markerName = string;
    }

    public ParkingLotInfoFragment() {
        // Required empty public constructor
    }

    TextView tx2;

    private String parkingLotAddresss;

    private String parkingLotName;
    private String parkingLotAddress;
    private String parkingLotRates;
    private String parkingLotHours;

    String output = "";

    private String liacourasGarageAddress = "";
    private String montgomeryGarageAddress = "";
    private String fifteenthStreetLotAddress = "";
    private String tylerLotAddress = "";
    private String diamondStreetLotAddress = "";
    private String templeTowersLotAddress = "";

    private View layout;

    private static RatingBar ratingBar1;
    private static TextView textViewRating;
    private static Button ratingButton;

    private static Button writeReviewButton;



    private boolean isInternetAvailable(){
        try{
            final InetAddress address = InetAddress.getByName("www.google.com");
            return !address.equals("");
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_parking_lot_info, container, false);


            ParkingLotInfo parkingLotInfo = new ParkingLotInfo(markerName);

            new parseOperation().execute();

            TextView tx1 = (TextView) layout.findViewById(R.id.textView1);
            tx2 = (TextView) layout.findViewById(R.id.textView2);
            TextView tx3 = (TextView) layout.findViewById(R.id.textView3);
            TextView tx4 = (TextView) layout.findViewById(R.id.textView4);

            parkingLotInfo.setMarkerName(markerName);
            parkingLotName = parkingLotInfo.getParkingLotName();
            tx1.setText(parkingLotName);

            //parkingLotInfo.setParkingLotAddress(markerName);
            //parkingLotAddress = parkingLotInfo.getParkingLotAddress();
            //setParkingLotAddresss(markerName);
            //tx2.setText(parkingLotAddresss);

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

    public class parseOperation extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("https://campusoperations.temple.edu/parking-transportation/garages-lots?campus=4").validateTLSCertificates(false).get();

                Elements addresses = doc.select("div.address");

                for (Element e: addresses){

                    output += e.text();
                    output += "\n";

                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String[] lines = output.split(System.getProperty("line.separator"));

            liacourasGarageAddress = lines[4];
            montgomeryGarageAddress = lines[6];
            fifteenthStreetLotAddress = lines[0];
            tylerLotAddress = lines[9];
            diamondStreetLotAddress = lines[3];
            templeTowersLotAddress = lines[7];


            if (markerName.equals("Diamond Street Lot")) {
                tx2.setText(diamondStreetLotAddress);
            } else if (markerName.equals("15th Street Lot")) {
                tx2.setText(fifteenthStreetLotAddress);
            } else if (markerName.equals("Liacouras Garage")) {
                tx2.setText(liacourasGarageAddress);
            } else if (markerName.equals("Montgomery Garage")) {
                tx2.setText(montgomeryGarageAddress);
            } else if (markerName.equals("Tyler Lot")) {
                tx2.setText(tylerLotAddress);
            } else if (markerName.equals("Temple Towers Lot")) {
                tx2.setText(templeTowersLotAddress);
            }

        }
    }

    }



package com.example.administrator.parkhere;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

//This class simply shows parking lot's image for clicked parking lot.
//This class uses images inside this project.
//As professor said in the class, I think I should've made files containing parking lot's info
//like parking lot's pictures, address, rates, etc...
public class ParkingLotPictureFragment extends Fragment {

    private View layout;


    public static String markerName = null;

    public void setMarkerName(String string){
        markerName = string;
    }

    public ParkingLotPictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_parking_lot_picture, container, false);

        ImageView imageView = (ImageView)layout.findViewById(R.id.imageViewLot);

        if (markerName.equals("Liacouras Garage")){
            imageView.setImageResource(R.drawable.liacouras);
        } else if(markerName.equals("Montgomery Garage")){
            imageView.setImageResource(R.drawable.montgomery);
        } else if(markerName.equals("15th Street Lot")){
            imageView.setImageResource(R.drawable.fifteenth);
        } else if(markerName.equals("Tyler Lot")){
            imageView.setImageResource(R.drawable.tyler);
        } else if(markerName.equals("Diamond Street Lot")){
            imageView.setImageResource(R.drawable.diamond);
        } else if(markerName.equals("Temple Towers Lot")){
            imageView.setImageResource(R.drawable.templetowers);
        }

        return layout;
    }


}

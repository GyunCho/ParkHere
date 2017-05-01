package com.example.administrator.parkhere;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


//I set up this review activity, but this class is not yet working as I hope
//because I don't have a database.
//My app should keep containing ratings and reviews even if user exits and comes back
//but without db, it can't be implemented yet
public class WriteReviewActivity extends AppCompatActivity {

    private static Button comepleteButton;
    private static EditText writeReviewText;
    private static TextView reviewTextView0;
    private static TextView reviewTextView1;
    private static TextView reviewTextView2;
    private static TextView reviewTextView3;

    Bundle bundle;
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        Intent myIntent = getIntent();

        bundle = getIntent().getExtras();
        message = bundle.getString("message");

        comepleteButton = (Button)findViewById(R.id.completeButton);
        writeReviewText = (EditText) findViewById(R.id.writeReviewText);

        final ParkingLotInfo parkingLotInfo = new ParkingLotInfo(message);


        reviewTextView0 = (TextView)findViewById(R.id.reviewTextView0);
        reviewTextView1 = (TextView)findViewById(R.id.reviewTextView1);
        reviewTextView2 = (TextView)findViewById(R.id.reviewTextView2);
        reviewTextView3 = (TextView)findViewById(R.id.reviewTextView3);

        comepleteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        //if((parkingLotInfo.getReview4() == null) || (parkingLotInfo.getReview4() == "")){
                        // if((parkingLotInfo.getReview0() == null) || (parkingLotInfo.getReview0() =="")){
                        setReview0();

                        //  }
                        //  }


                        Toast.makeText(WriteReviewActivity.this,
                                "You Successfully Made a Review",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );

        parkingLotInfo.setReview0("The staff was friendly and the parking space was spacious");
        reviewTextView0.setText(parkingLotInfo.getReview0());

    }

    public void setReview0(){
        final ParkingLotInfo parkingLotInfo = new ParkingLotInfo(message);
        parkingLotInfo.setReview0("sdfsdf");

    }


}


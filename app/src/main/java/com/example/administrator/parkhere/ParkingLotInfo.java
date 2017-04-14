package com.example.administrator.parkhere;

/**
 * Created by GyunCho on 4/13/17.
 */

public class ParkingLotInfo {

    private String parkingLotName;
    private String parkingLotAddress;
    private String parkingLotRates;
    private String parkingLotHours;

    private String review0 = "";
    private String review1 = "";
    private String review2 = "";
    private String review3 = "";
    private String review4 = "";



    public String getReview0() {
        return this.review0;
    }
    public String getReview1() {
        return this.review1;
    }
    public String getReview2() {
        return this.review2;
    }
    public String getReview3() {
        return this.review3;
    }
    public String getReview4() {
        return this.review4;
    }

    public void setReview0(String string){
        this.review0 = string;
    }

    public void setReview1(String string){
        this.review1 = string;
    }

    public void setReview2(String string){
        this.review2 = string;
    }

    public void setReview3(String string){
        this.review3 = string;
    }

    public void setReview4(String string){
        this.review4 = string;
    }



    public ParkingLotInfo(String name) {
        this.parkingLotName = name;
    }


    public static String markerName1 = null;

    public void setMarkerName(String string) {
        markerName1 = string;
    }

    public String getParkingLotName() {
        return this.parkingLotName;
    }

    public String getParkingLotAddress() {
        return this.parkingLotAddress;
    }

    public String getParkingLotRates() {
        return this.parkingLotRates;
    }

    public String getParkingLotHours() {
        return this.parkingLotHours;
    }


    public void setParkingLotAddress(String markerName) {
        if (markerName.equals("Diamond Street Lot")) {
            this.parkingLotAddress = "1140 W. Diamond Street\n" +
                    "Philadelphia, PA 19122";
        } else if (markerName.equals("15th Street Lot")) {
            this.parkingLotAddress = "1855 N. 15th Street\n" +
                    "Philadelphia, PA 19122";
        } else if (markerName.equals("Liacouras Garage")) {
            this.parkingLotAddress = "1710 N. 15th St.\n" +
                    "Philadelphia, PA 19121";
        } else if (markerName.equals("Montgomery Garage")) {
            this.parkingLotAddress = "1859 N. 11th Street\n" +
                    "Philadelphia, PA 19122";
        } else if (markerName.equals("Tyler Lot")) {
            this.parkingLotAddress = "1220 W. Diamond Street\n" +
                    "Philadelphia, PA 19122";
        } else if (markerName.equals("Temple Towers Lot")) {
            this.parkingLotAddress = "1651 N. 13th Street\n" +
                    "Philadelphia, PA 19122";
        }

    }

    public void setParkingLotRates(String markerName) {
        if (markerName.equals("Diamond Street Lot")) {
            this.parkingLotRates = "$17 per entry for Visitors\n" +
                    "$240 per semester for Students\n" +
                    "$120 per month for Faculties";
        } else if (markerName.equals("15th Street Lot")) {
            this.parkingLotRates = "$120.00 per month for Faculties";
        } else if (markerName.equals("Liacouras Garage")) {
            this.parkingLotRates = "$17 per entry for Visitors\n" +
                    "$240 per semester for Students (Commuting)\n" +
                    "$400 per semester for Students (Overnight)\n" +
                    "$8 per entry for both Students & Faculties\n" +
                    "$120 per month for Faculties";
        } else if (markerName.equals("Montgomery Garage")) {
            this.parkingLotRates =
                    "$400 per semester for Students (Overnight)\n" +
                    "$120 per month for Faculties";
        } else if (markerName.equals("Tyler Lot")) {
            this.parkingLotRates =
                    "$400 per semester for Students (Overnight)\n" +
                    "$120 per month for Faculties";
        } else if (markerName.equals("Temple Towers Lot")) {
            this.parkingLotRates =
                    "$240 per semester for Students (Commuting)\n" +
                    "$120 per month for Faculties";
        }
    }

    public void setParkingLotHours(String markerName) {
        if (markerName.equals("Diamond Street Lot")) {
            this.parkingLotHours = "MONDAY-FRIDAY:  7:00AM-10:50PM\n" +
                    "SATURDAY-SUNDAY:  CLOSED";
        } else if (markerName.equals("15th Street Lot")) {
            this.parkingLotHours = "MONDAY-FRIDAY:  6:45AM-10:50PM\n" +
                    "SATURDAY-SUNDAY:  CLOSED";
        } else if (markerName.equals("Liacouras Garage")) {
            this.parkingLotHours = "MONDAY-FRIDAY:  5:30AM-2:00AM\n" +
                    "SATURDAY-SUNDAY:  5:30AM-2:00AM";
        } else if (markerName.equals("Montgomery Garage")) {
            this.parkingLotHours = "MONDAY-FRIDAY:  5:30AM-9:30PM\n" +
                    "SATURDAY-SUNDAY:  CLOSED";
        } else if (markerName.equals("Tyler Lot")) {
            this.parkingLotHours = "MONDAY-FRIDAY:  24 HOURS\n" +
                    "SATURDAY-SUNDAY:  24 HOURS";
        } else if (markerName.equals("Temple Towers Lot")) {
            this.parkingLotHours = "MONDAY-FRIDAY:  6:45AM-10:50PM\n" +
                    "SATURDAY-SUNDAY:  CLOSED";
        }
    }

}

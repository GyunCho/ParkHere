package com.example.administrator.parkhere;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getter_isCorrect() throws Exception {

        ParkingLotInfo parkingLotInfo = new ParkingLotInfo("Diamond Street Lot");
        String parkingLotName = parkingLotInfo.getParkingLotName();

        assertEquals("Diamond Street Lot", parkingLotName);
    }

    @Test
    public void getter_isNotCorrect() throws Exception {

        ParkingLotInfo parkingLotInfo = new ParkingLotInfo("Liacouras Garage");
        String parkingLotName = parkingLotInfo.getParkingLotName();

        assertNotEquals("Temple Garage", parkingLotName);
    }

    @Test
    public void setter_isCorrect() throws Exception{
        ParkingLotInfo parkingLotInfo = new ParkingLotInfo("Montgomery Garage");
        parkingLotInfo.setParkingLotAddress("Montgomery Garage");

        String parkingLotAddress = parkingLotInfo.getParkingLotAddress();

        assertEquals("1859 N. 11th Street\n" +
                "Philadelphia, PA 19122", parkingLotAddress);

    }

    @Test
    public void setter_isNotCorrect() throws Exception{

        ParkingLotInfo parkingLotInfo = new ParkingLotInfo("Tyler Lot");
        parkingLotInfo.setParkingLotAddress("Tyler Lot");

        String parkingLotAddress = parkingLotInfo.getParkingLotAddress();

        assertNotEquals("1859 N. 11th Street\n" +
                "Philadelphia, PA 19122", parkingLotAddress);

    }
}
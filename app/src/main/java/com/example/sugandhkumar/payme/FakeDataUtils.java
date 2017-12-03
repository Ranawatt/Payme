package com.example.sugandhkumar.payme;

import java.sql.Timestamp;

/**
 * Created by sugandh kumar on 17-08-2017.
 */

public class FakeDataUtils {
    public static BoardingPassInfo generateFakeBoardingPassInfo(){
        BoardingPassInfo bpi = new BoardingPassInfo();

        bpi.passengerName="MR RANDOM PERSON";
        bpi.flightCode = "UD 777";
        bpi.originCode = "JFK";
        bpi.destCode = "DCA";

        long now = System.currentTimeMillis();
        long randomMinutesUntilBoarding = (long) (Math.random()*30);
        long toatalBoardingMinutes = 40;
        long randomFlightLengthHours = (long) (Math.random()*5 + 1);
        long boardingMillis = now + (randomMinutesUntilBoarding);
        long departure = boardingMillis + (toatalBoardingMinutes);
        long arrival = randomFlightLengthHours;

        bpi.boardingTime = new Timestamp(boardingMillis);
        bpi.departureTime = new Timestamp(departure);
        bpi.arrivalTime = new Timestamp(arrival);
        bpi.departureTerminal = "3A";
        bpi.departureGate = "33C";
        bpi.seatNumber = "1A";
        return bpi;
    }
}

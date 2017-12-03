package com.example.sugandhkumar.payme;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sugandhkumar.payme.databinding.ActivityFlightDetailsBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class FlightDetails extends AppCompatActivity {

    ActivityFlightDetailsBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_flight_details);
        BoardingPassInfo fakeBoardingInfo = FakeDataUtils.generateFakeBoardingPassInfo();
        displayBoardingPassInfo(fakeBoardingInfo);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void displayBoardingPassInfo(BoardingPassInfo info) {
        mBinding.tvPassengerName.setText(info.passengerName);
        mBinding.tvOriginAirport.setText(info.originCode);
        mBinding.tvDestinationAirport.setText(info.destCode);
        mBinding.tvFlightCode.setText(info.flightCode);

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String boardingTime = formatter.format(info.boardingTime);
        String depatureTime = formatter.format(info.departureTime);
        String arrivalTime =  formatter.format(info.arrivalTime);

        mBinding.tvBoardTime.setText(boardingTime);
        mBinding.tvDepartureTime.setText(depatureTime);
        mBinding.tvArrivalTime.setText(arrivalTime);

        long totalMinutesUntilBoarding = info.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalMinutesUntilBoarding);
        long minutesLessHourUntilBoarding = totalMinutesUntilBoarding - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String hoursAndMinutesUntilBoarding = hoursUntilBoarding + ":"+minutesLessHourUntilBoarding;

        mBinding.tvBoardingInCountdown.setText(hoursAndMinutesUntilBoarding);
        mBinding.tvTerminal.setText(info.departureTerminal);
        mBinding.tvGate.setText(info.departureGate);
        mBinding.tvSeat.setText(info.seatNumber);
    }
}
package com.example.sugandhkumar.payme.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sugandhkumar.payme.Main11Activity;
import com.example.sugandhkumar.payme.R;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class WaterchargeFragment extends Fragment implements View.OnClickListener {
    private EditText etWater;
    private EditText etConsumer;
    private Button btnPay;
    public WaterchargeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View wView = inflater.inflate(R.layout.fragment_water,container,false);
        initView(wView);
        return wView;
    }

    private void initView(View iView){
        etWater = (EditText) iView.findViewById(R.id.etWaterBoard);
        etConsumer = (EditText) iView.findViewById(R.id.etConsumerNumber);
        btnPay = (Button) iView.findViewById(R.id.btnBill);

        btnPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int aId = v.getId();
        if (aId == R.id.btnBill){
            Intent aIntent = new Intent(getActivity().getApplicationContext(),Main11Activity.class);
            aIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(aIntent);
        }
    }
}

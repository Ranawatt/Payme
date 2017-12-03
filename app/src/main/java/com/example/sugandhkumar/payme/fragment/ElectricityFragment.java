package com.example.sugandhkumar.payme.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.sugandhkumar.payme.Main11Activity;
import com.example.sugandhkumar.payme.R;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class ElectricityFragment extends Fragment {
    private Context eContext;
    private RadioButton radioBoard,radioApartment;
    private EditText etState, etBoard,etConsumer;
    private Button btnPay,btnOffers,btnHelp;

    public ElectricityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View eView = inflater.inflate(R.layout.frag_electricity,container,false);
        initView(eView);
        return eView;
    }

    private void initView(View iView){
        etState = (EditText) iView.findViewById(R.id.etState);
        etBoard = (EditText) iView.findViewById(R.id.etBoard);
        etConsumer = (EditText) iView.findViewById(R.id.etConsumer);
        btnPay = (Button) iView.findViewById(R.id.get_bill);
        btnOffers = (Button) iView.findViewById(R.id.btOffers);
        btnHelp = (Button) iView.findViewById(R.id.btHelp);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPay.setTextColor(Color.BLUE);
                String state = etState.getText().toString().trim();
                String board = etBoard.getText().toString().trim();
                String consumer = etConsumer.getText().toString().trim();

                Intent intent = new Intent(getActivity().getApplicationContext(),Main11Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOffers.setTextColor(Color.BLUE);
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHelp.setTextColor(Color.BLUE);
            }
        });
    }
}

package com.example.sugandhkumar.payme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class DthrechargeFragment extends Fragment {
    private EditText etOperator,smartCardNumber,amount;
    private Button btnRecharge,btnOffer, btnHelp;
    public DthrechargeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dView = inflater.inflate(R.layout.fragment_dth,container,false);
        initView(dView);
        return dView;
    }

    private void initView(View iView){
        etOperator = (EditText) iView.findViewById(R.id.dthOperator);
        smartCardNumber = (EditText) iView.findViewById(R.id.smartcard);
        amount = (EditText) iView.findViewById(R.id.amnt);
        btnRecharge = (Button) iView.findViewById(R.id.btnPayment);
        btnOffer = (Button) iView.findViewById(R.id.btnOffer);
        btnHelp = (Button) iView.findViewById(R.id.btnHelp);

        btnRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),Main11Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
